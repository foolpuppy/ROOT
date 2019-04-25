package top.wigon.servlet.user;

import top.wigon.entity.User;
import top.wigon.service.impl.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/25 14:33
 **/
@WebServlet("/regist")
public class UserRegistServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        user.setTel(phone);
        user.setEmail(email);
        UserServiceImpl userService = new UserServiceImpl();
        boolean flag = userService.userAdd(user);
        if (flag) {


            resp.getWriter().println("注册成功");
            resp.getWriter().println(user.toString());
        } else {


            resp.getWriter().println("注册失败");
        }
    }
}
