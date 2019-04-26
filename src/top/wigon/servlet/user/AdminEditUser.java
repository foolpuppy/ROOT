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
 * @date 2019/4/26 16:12
 **/
@WebServlet("/AdminEditUser")
public class AdminEditUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String user_id = (String) req.getSession().getAttribute("user_id");
        String user_id = req.getParameter("user_id");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String roletype = req.getParameter("roletype");
        User user = new User();
        user.setUserId(user_id);
        user.setUserName(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setRoleType(password);
        UserServiceImpl userService = new UserServiceImpl();
        if (userService.userEdit(user)) {

            //修改成功

        } else {
            //修改失败
        }
    }
}