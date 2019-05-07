package top.wigon.servlet.admin;

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
        String user_id = req.getParameter("userId");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String tel = req.getParameter("tel");
        String roleType = req.getParameter("roleType");
        String avatarPath = req.getParameter("avatarPath");
        User user = new User();
        user.setUserId(user_id);
        user.setUserName(username);
        user.setEmail(email);
        user.setTel(tel);
        if (avatarPath != null) {
            user.setAvatarPath(avatarPath);
        }
        user.setRoleType(roleType);
        if (password != null) {
            user.setPassword(MD5Util.MD5EncodeUtf8(password));
        }
        UserServiceImpl userService = new UserServiceImpl();
        if (userService.userEdit(user)) {

            resp.setContentType("text/plain; charset=UTF-8;");
            resp.getWriter().write("1");

        } else {
            //修改失败
        }
    }
}
