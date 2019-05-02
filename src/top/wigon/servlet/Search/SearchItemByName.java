package top.wigon.servlet.Search;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import top.wigon.entity.Item;
import top.wigon.service.impl.ItemServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/28 12:37
 **/
@WebServlet("/search")
public class SearchItemByName extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String item_title = req.getParameter("title");
        ItemServiceImpl itemService = new ItemServiceImpl();
        Item item = new Item();
        item.setTitle(item_title);
        List<Item> userList = itemService.findItemsByName(item);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        String JSON = objectMapper.writeValueAsString(userList);
        StringBuffer content = new StringBuffer();
        content.append("{\"status\":");
        content.append("0");
        content.append(",\"content\":");
        content.append(JSON);
        content.append("}");
        String jsonString = content.toString();
        resp.setContentType("text/plain; charset=UTF-8;");
        resp.getWriter().write(jsonString);

    }
}
