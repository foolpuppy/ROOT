package top.wigon.servlet.mainPage;

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
        //todo 前端整合
        resp.setContentType("text/plain; charset=UTF-8;");
    }

    @Test
    void test() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        ItemServiceImpl itemService = new ItemServiceImpl();
        //推荐产品
        List<Item> items_0f = itemService.findItemsByCategoryCols("电子产品", 5);
        List<Item> items_1f = itemService.findItemsByCategoryCols("衣橱服务", 5);
        List<Item> items_2f = itemService.findItemsByCategoryCols("生鲜水果", 5);
        List<Item> items_3f = itemService.findItemsByCategoryCols("美妆馆", 5);
        List<Item> items_all = itemService.findItemsByCategoryCols("美妆馆", 20);
        String JSON;
        StringBuffer content = new StringBuffer();
        content.append("{\"status\": 0,\"floor\": {\"bigimg\": \"res/static/img/s_img1.jpg\",");
        content.append("\"banner\": {");
        content.append("\"cont\":");
        JSON = objectMapper.writeValueAsString(items_0f);
        content.append(JSON);
        content.append("}},");
        content.append("\"proct\": [{\"floorNum\": \"1F\",\"productItem\": \"product-item1\",\"carImg\": \"res/static/img/icon_gou.png\", \"text\": \"电子产品\",\"bigImg\": \"res/static/img/img12.jpg\",\n" +
                " \"imgBox\":");
        JSON = objectMapper.writeValueAsString(items_1f);
        content.append(JSON);
        content.append("},");
        content.append("{\"floorNum\": \"2F\",\"productItem\": \"product-item2\",\"carImg\": \"res/static/img/icon_gou.png\",\"text\": \"服饰衣帽\",\"bigImg\": \"res/static/img/img12.jpg\",\"imgBox\": ");
        JSON = objectMapper.writeValueAsString(items_2f);
        content.append(JSON);
        content.append("},");
        content.append("{\"floorNum\": \"3F\",\"productItem\": \"product-item3\",\"carImg\": \"res/static/img/icon_gou.png\", \"text\": \"化妆用品\",\"bigImg\": \"res/static/img/img12.jpg\",\"imgBox\": ");
        JSON = objectMapper.writeValueAsString(items_3f);
        content.append(JSON);
        content.append("}],");
        content.append("\"productList\": ");
        JSON = objectMapper.writeValueAsString(items_all);
        content.append(JSON);
        content.append("}");

        //TODO 首页初始化

    }
}
