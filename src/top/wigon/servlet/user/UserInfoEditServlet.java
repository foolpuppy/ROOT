package top.wigon.servlet.user;

import top.wigon.common.MD5Util;
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
 * @date 2019/4/26 15:43
 **/
@WebServlet("/userEdit")
public class UserInfoEditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String user_id = (String) req.getSession().getAttribute("user_id");
        String user_id = req.getParameter("user_id");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = new User();
        user.setUserId(user_id);
        user.setUserName(username);
        user.setEmail(email);
        user.setPassword(MD5Util.MD5EncodeUtf8(password));
        UserServiceImpl userService = new UserServiceImpl();
        if (userService.userEdit(user)) {

            //修改成功

        } else {
            //修改失败
        }
    }
}
