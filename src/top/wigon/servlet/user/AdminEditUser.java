package top.wigon.servlet.user;

import top.wigon.service.impl.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/26 16:12
 **/
@WebServlet("/AdminEditUser")
public class AdminEditUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String userId = req.getParameter("userId");
        String roleType = req.getParameter("roleType");
        UserServiceImpl userService = new UserServiceImpl();
        if (userService.setUserRoleTypeById(userId, roleType)) {

            //todo 修改成功

        } else {
            //todo 修改失败
        }
    }
}
