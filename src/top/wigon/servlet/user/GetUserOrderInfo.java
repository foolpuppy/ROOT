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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserServiceImpl userService = new UserServiceImpl();
        String jsonResult = userService.getUserOrderInfoByTel(req.getParameter("userTel") == null ? (String) req.getSession().getAttribute("user_tel") : req.getParameter("userTel"));
        resp.setContentType("text/plain; charset=UTF-8;");
        String content = ("{\n" +
                "  \"status\": 0,\n" +
                "  \"orderList\":") +
                jsonResult +
                "}";
        resp.getWriter().write(content);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
