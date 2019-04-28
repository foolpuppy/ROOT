package top.wigon.servlet.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/28 9:24
 **/
@WebServlet("/UserLogOut")
public class UserLogOut extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //无效Session
        req.getSession().invalidate();
        Cookie cookie = null;
        Cookie[] cookies = null;
        // 获取当前域名下的cookies，是一个数组
        cookies = req.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if ((cookie.getName()).compareTo("userTel") == 0) {
                    cookie.setMaxAge(0);
                    resp.addCookie(cookies[i]);
                }
            }
        }
        resp.sendRedirect("index.html");
    }
}
