package top.wigon.servlet.item;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
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
 * @date 2019/4/29 9:36
 **/
@WebServlet("/GetAllItems")
public class GetAllItems extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ItemServiceImpl itemService = new ItemServiceImpl();
        //返回模糊查询的商品集合
        List<Item> items = itemService.getAll();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        String JSON = objectMapper.writeValueAsString(items);
        StringBuffer content = new StringBuffer();
        content.append("{\"status\":");
        content.append("0");
        content.append(",\"menu\":");
        content.append("{\"milk\":");
        content.append("{\"content\":");
        content.append(JSON);
        content.append("}}}");
        String jsonString = content.toString();
        resp.setContentType("text/plain; charset=UTF-8;");
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
