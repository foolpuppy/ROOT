package top.wigon.servlet.user;

import top.wigon.common.MD5Util;
import top.wigon.entity.User;
import top.wigon.service.impl.UserServiceImpl;

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
 * @date 2019/4/25 11:13
 **/
@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        if (req.getSession().getAttribute("verify").equals(req.getParameter("verifiCode"))) {
            resp.setContentType("text/html;charset=utf-8");
            String tel = req.getParameter("phone");
            String password = req.getParameter("password");
            User user = new User();
            user.setTel(tel);
            user.setPassword(MD5Util.MD5EncodeUtf8(password));
            UserServiceImpl userService = new UserServiceImpl();
            boolean login = userService.userLoginByphone(user);
            if (login) {
                //用户信息存入Session
                req.getSession().setAttribute("user", user);
                req.getSession().setAttribute("user_tel", tel);
                //存用户ID 到session
                req.getSession().setAttribute("user_id", userService.getUserIDByTel(user.getTel()));
                //用户Tel 唯一ID 存Cookies
                Cookie cookie = new Cookie("userTel", tel);
                cookie.setMaxAge(60 * 30);
                resp.addCookie(cookie);
                resp.sendRedirect("index.html");
            } else {

                resp.sendRedirect("login.html");
            }
        } else {
            resp.getWriter().write("<script>alert('验证码有误');window.location.href='login.html';</script>");
        }
    }
}
