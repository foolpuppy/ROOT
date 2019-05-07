package top.wigon.servlet.admin;

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
 * @date 2019/5/6 20:16
 **/
@WebServlet("/getAllOrders")
public class GetAllOrders extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");
        List<Order> items;
        OrderServiceImpl orderService = new OrderServiceImpl();
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> whereMap = new HashMap<>();
        try {
            //search是搜索的关键词
            if (search != null) {
                whereMap.put("order_id", search);
            }
            items = whereMap.size() > 0 ? orderService.getAllOrders(whereMap, page == null ? -1 : Integer.parseInt(page), limit == null ? 10 : Integer.parseInt(limit)) : orderService.getAllOrders(page == null ? -1 : Integer.parseInt(page), limit == null ? 10 : Integer.parseInt(limit));
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            String JSON = objectMapper.writeValueAsString(items);
            StringBuilder content = new StringBuilder();
            content.append("{\n" +
                    "  \"code\": 0\n" +
                    "  ,\"msg\": \"\"\n" +
                    "  ,\"count\": \"" + items.size() + "\"\n" +
                    "  ,\"data\": \n");
            content.append(JSON);
            content.append("}");
            resp.setContentType("text/plain; charset=UTF-8;");
            resp.getWriter().write(content.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
