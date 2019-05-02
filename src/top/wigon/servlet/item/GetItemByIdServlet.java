package top.wigon.servlet.item;

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

/**
 * @author L
 * @version 1.0
 * @date 2019/4/30 9:59
 **/
@WebServlet("/getDetail")
public class GetItemByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String item_id = req.getParameter("id");
        ItemServiceImpl itemService = new ItemServiceImpl();
        Item item = itemService.findbyitemid(item_id);
        resp.setContentType("text/plain; charset=UTF-8;");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        String JSON = objectMapper.writeValueAsString(item);
        StringBuffer content = new StringBuffer();
        content.append("{\n" +
                "  \"status\": 0,\n" +
                "  \"detailList\":[");
        content.append(JSON);
        content.append("]}");
        resp.getWriter().println(content.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
