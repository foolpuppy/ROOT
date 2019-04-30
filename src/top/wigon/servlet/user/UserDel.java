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
 * @date 2019/4/26 16:15
 **/
@WebServlet("/UserDel")
public class UserDel extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user_id = req.getParameter("user_id");
        UserServiceImpl userService = new UserServiceImpl();
        User user = new User();
        user.setUserId(user_id);
        resp.setContentType("text/html;charset=utf-8");
        if (userService.userDel(user)) {

            //todo 用户删除成功
        } else {
            //todo 用户删除失败
        }
    }
}
