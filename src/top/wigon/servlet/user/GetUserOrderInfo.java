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
 * @date 2019/5/1 18:25
 **/
@WebServlet("/orderInfo")
public class GetUserOrderInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserServiceImpl userService = new UserServiceImpl();
        String JSONResult = userService.getUserOrderInfoByTel((String) req.getSession().getAttribute("user_tel"));
        resp.setContentType("text/plain; charset=UTF-8;");
        resp.getWriter().write(JSONResult);

    }
}
