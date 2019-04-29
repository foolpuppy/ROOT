package top.wigon.servlet.Search;

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
import java.util.List;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/29 18:46
 **/
@WebServlet("/searchByCategory")
public class SearchByCategory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String category = req.getParameter("category");
        ItemServiceImpl itemService = new ItemServiceImpl();
        List<Item> itemList = itemService.findItemsByCategory(category);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        String JSON = objectMapper.writeValueAsString(itemList);
        resp.setContentType("text/plain; charset=UTF-8;");
        resp.getWriter().write(JSON);
    }
}
