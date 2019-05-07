package top.wigon.servlet.shop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import top.wigon.entity.Order;
import top.wigon.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author L
 * @version 1.0
 * @date 2019/5/6 18:54
 **/
@WebServlet("/SellergetMyOrders")
public class SellerGetMyOrders extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = String.valueOf(req.getSession().getAttribute("user_id"));
        String search = req.getParameter("search");
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");
        OrderServiceImpl orderService = new OrderServiceImpl();
        List<Order> orders;
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> whereMap = new HashMap<>();
        if (search != null) {
            whereMap.put("order_id", search);
        }
        orders = whereMap.size() > 0 ? orderService.getMyOrders(userId, whereMap, page == null ? -1 : Integer.parseInt(page), limit == null ? 10 : Integer.parseInt(limit)) : orderService.getMyOrders(userId, page == null ? -1 : Integer.parseInt(page), limit == null ? 10 : Integer.parseInt(limit));
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        String JSON = objectMapper.writeValueAsString(orders);
        StringBuilder content = new StringBuilder();
        content.append("{\n" +
                "  \"code\": 0\n" +
                "  ,\"msg\": \"\"\n" +
                "  ,\"count\": \"" + orders.size() + "\"\n" +
                "  ,\"data\": \n");
        content.append(JSON);
        content.append("}");
        resp.setContentType("text/plain; charset=UTF-8;");
        resp.getWriter().write(content.toString());
    }
}
