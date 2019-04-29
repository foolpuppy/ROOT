package top.wigon.servlet.mainPage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
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
 * @date 2019/4/29 19:18
 **/
@WebServlet("/init")
public class init extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ItemServiceImpl itemService = new ItemServiceImpl();
        //推荐产品
        List<Item> items_0f = itemService.findItemsByCategoryCols("电子产品", 5);
        List<Item> items_1f = itemService.findItemsByCategory("衣橱服务");
        List<Item> items_2f = itemService.findItemsByCategory("生鲜水果");
        List<Item> items_3f = itemService.findItemsByCategory("美妆馆");
        objectMapper.writeValueAsString(items_0f);
        StringBuffer content = new StringBuffer();
        content.append("{\"status\": 0,\"floor\": {\"bigimg\": \"res/static/img/s_img1.jpg\",");
        content.append("\"banner\": {");
        content.append("\"cont\":");
        content.append(items_0f);
        System.out.println();
    }

    @Test
    void test() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ItemServiceImpl itemService = new ItemServiceImpl();
        //推荐产品
        List<Item> items_0f = itemService.findItemsByCategoryCols("电子产品", 5);
        List<Item> items_1f = itemService.findItemsByCategory("衣橱服务");
        List<Item> items_2f = itemService.findItemsByCategory("生鲜水果");
        List<Item> items_3f = itemService.findItemsByCategory("美妆馆");
        objectMapper.writeValueAsString(items_0f);
        StringBuffer content = new StringBuffer();
        content.append("{\"status\": 0,\"floor\": {\"bigimg\": \"res/static/img/s_img1.jpg\",");
        content.append("\"banner\": {");
        content.append("\"cont\":");
        content.append(items_0f);
        System.err.println(content);

    }
}
