package top.wigon.servlet.user;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
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
public class UserIsLogInServlet implements Filter {
    //未登录也可以访问的URL
    private static final Set<String> NOT_ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(
            Arrays.asList("/commodity.html", "/all_order.html", "/commodity.html", "/package.html", "/consumer_center.html", "/consumer_info.html")));

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String path = httpServletRequest.getRequestURI().substring(httpServletRequest.getContextPath().length()).replaceAll("[/]+$", "");
        HttpSession session = httpServletRequest.getSession();
        boolean loggedIn = session.getAttribute("user") != null;
        boolean allowedPath = NOT_ALLOWED_PATHS.contains(path);
        if (loggedIn || !allowedPath) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            //System.out.println("通过");
        } else {
            System.err.println("未登录，访问 " + path + " 未通过 , isLogin " + loggedIn + " , allowedPath: " + allowedPath);
            httpServletResponse.sendRedirect("login.html");
        }
    }
}