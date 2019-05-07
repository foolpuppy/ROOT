package top.wigon.servlet.shop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import top.wigon.entity.Item;
import top.wigon.service.impl.ItemServiceImpl;

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
@WebServlet("/sellergetMyItem")
public class GetMyItem extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = String.valueOf(req.getSession().getAttribute("user_id"));
        String search = req.getParameter("search");
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");
        ItemServiceImpl itemService = new ItemServiceImpl();
        //返回模糊查询的商品集合
        List<Item> items;
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> whereMap = new HashMap<>();
        if (search != null) {
            whereMap.put("item_id", search);
            whereMap.put("item_category", search);
            whereMap.put("item_title", search);
        }
        items = whereMap.size() > 0 ? itemService.getMyItems(userId, whereMap, page == null ? -1 : Integer.parseInt(page), limit == null ? 10 : Integer.parseInt(limit)) : itemService.getMyItems(userId, page == null ? -1 : Integer.parseInt(page), limit == null ? 10 : Integer.parseInt(limit));
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
    }
}
