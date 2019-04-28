package top.wigon.servlet.user;

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
 * @date 2019/4/28 16:01
 **/
@WebServlet("/checkTel")

public class CheckTelExist extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tel = req.getParameter("phone");
        UserServiceImpl userService = new UserServiceImpl();
        boolean isExist = userService.checkTelExist(tel);
        resp.setContentType("text/html;charset=utf-8");
        /**
         * 判断电话号是否存在在数据库
         */
        resp.getWriter().write(isExist ? "1" : "0");
    }
}
