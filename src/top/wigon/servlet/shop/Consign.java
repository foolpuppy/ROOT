package top.wigon.servlet.shop;

import top.wigon.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author L
 * @version 1.0
 * @date 2019/5/7 11:34
 **/
@WebServlet("/consign")
public class Consign extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] itemList = req.getParameterValues("arr[]");
        OrderServiceImpl orderService = new OrderServiceImpl();
        int cnt = 0;
        for (String item : itemList) {
            cnt += orderService.updateOrderState(item, 4) ? 1 : 0;
        }
        resp.setContentType("text/plain; charset=UTF-8;");
        resp.getWriter().write("1");
    }
}
