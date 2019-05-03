package top.wigon.servlet.user;

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
 * @date 2019/5/3 13:43
 **/
@WebServlet("/delUserOrder")
public class DelUserOrder extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderToDel = req.getParameter("order_no");
        String currentUserId = (String) req.getSession().getAttribute("user_id");
        OrderServiceImpl orderService = new OrderServiceImpl();
        if (orderService.delUserOrder(orderToDel, currentUserId)) {
            resp.setContentType("text/plain; charset=UTF-8;");
            resp.getWriter().write("删除成功");
        } else {
            resp.getWriter().write("删除失败");
        }
        resp.sendRedirect("all_order.html");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
