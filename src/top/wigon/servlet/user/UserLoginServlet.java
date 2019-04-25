package top.wigon.servlet.user;

import top.wigon.entity.User;
import top.wigon.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
        String tel = req.getParameter("phone");
        String password = req.getParameter("password");
        User user = new User();
        user.setTel(tel);
        user.setPassword(password);
        UserServiceImpl userService = new UserServiceImpl();
        boolean login = userService.userLoginByphone(user);
        if (login) {
            resp.getWriter().println("HELLO");
        } else {
            resp.getWriter().println("NOPE");
        }

    }
}
