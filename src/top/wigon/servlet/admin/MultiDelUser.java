package top.wigon.servlet.admin;

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
 * @date 2019/5/5 18:35
 **/
@WebServlet("/multiDel")
public class MultiDelUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] userList = req.getParameterValues("arr[]");
        UserServiceImpl userService = new UserServiceImpl();
        int cnt = 0;
        for (String user : userList) {
            cnt += userService.userDel(user) ? 1 : 0;
        }
        resp.setContentType("text/plain; charset=UTF-8;");
        resp.getWriter().write("1");
    }
}
