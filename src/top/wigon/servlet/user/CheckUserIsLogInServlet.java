package top.wigon.servlet.user;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/28 15:00
 **/

@WebFilter("/*")
public class CheckUserIsLogInServlet implements Filter {
    /**
     * 未登录不允许访问的路径
     */
    private static final Set<String> NOT_ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(
            Arrays.asList("/confirm_orders.html", "/all_order.html", "/package.html", "/consumer_center.html", "/consumer_info.html")));

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String path = httpServletRequest.getRequestURI().substring(httpServletRequest.getContextPath().length()).replaceAll("[/]+$", "");
        HttpSession session = httpServletRequest.getSession();
        boolean loggedIn = session.getAttribute("user") != null;
        if (!loggedIn) {
            delCookies(httpServletRequest, httpServletResponse, loggedIn);
        }
        boolean allowedPath = NOT_ALLOWED_PATHS.contains(path);
        if (loggedIn || !allowedPath) {
            if (path.contains("/start") || path.contains(("/seller"))) {
                boolean success = false;
                if (path.contains("/start")) {
                    if (String.valueOf(session.getAttribute("userType")).equals("2")) {
                        success = true;
                        filterChain.doFilter(httpServletRequest, httpServletResponse);

                    }
                }
                if (path.contains("/seller")) {
                    if (String.valueOf(session.getAttribute("userType")).equals("1") || String.valueOf(session.getAttribute("userType")).equals("2")) {
                        success = true;
                        filterChain.doFilter(httpServletRequest, httpServletResponse);

                    }
                }
                if (!success) {
                    httpServletResponse.sendRedirect("index.html");
                }
            } else {
                filterChain.doFilter(httpServletRequest, httpServletResponse);
            }
        } else {
            System.err.println("未登录，访问 " + path + " 未通过 , isLogin " + loggedIn + " , allowedPath: " + allowedPath + " , roleType= " + session.getAttribute("userType"));
            httpServletResponse.sendRedirect("login.html");
        }
    }

    /**
     * 删除Cookies
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param loggedIn
     */
    private void delCookies(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Boolean loggedIn) {
        Cookie cookie = null;
        Cookie[] cookies = null;
        // 获取当前域名下的cookies，是一个数组
        cookies = httpServletRequest.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if ((cookie.getName()).compareTo("userTel") == 0) {
                    cookie.setMaxAge(0);
                    httpServletResponse.addCookie(cookies[i]);
                    System.err.println("因为 session is:" + loggedIn + " , 所以 Cookies  userTel 已删除");
                }
            }
        }
    }
}