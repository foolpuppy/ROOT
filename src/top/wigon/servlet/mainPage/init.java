package top.wigon.servlet.mainPage;

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
 * @date 2019/4/29 19:18
 **/
@WebServlet("/init")
public class init extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        ItemServiceImpl itemService = new ItemServiceImpl();
        //推荐产品
        List<Item> items_0f = itemService.findItemsByPrice(100, 0, 4);
        List<Item> items_1f = itemService.findItemsByCategoryCols("笔记本电脑", 5);
        List<Item> items_2f = itemService.findItemsByCategoryCols("水果生鲜", 5);
        List<Item> items_3f = itemService.findItemsByCategoryCols("美妆馆", 5);
        List<Item> items_all = itemService.getAll();
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
        content.append("{\"floorNum\": \"2F\",\"productItem\": \"product-item2\",\"carImg\": \"res/static/img/icon_gou.png\",\"text\": \"水果生鲜\",\"bigImg\": \"res/static/img/img12.jpg\",\"imgBox\": ");
        JSON = objectMapper.writeValueAsString(items_2f);
        content.append(JSON);
        content.append("},");
        content.append("{\"floorNum\": \"3F\",\"productItem\": \"product-item3\",\"carImg\": \"res/static/img/icon_gou.png\", \"text\": \"美妆馆\",\"bigImg\": \"res/static/img/img12.jpg\",\"imgBox\": ");
        JSON = objectMapper.writeValueAsString(items_3f);
        content.append(JSON);
        content.append("}],");
        content.append("\"productList\": ");
        JSON = objectMapper.writeValueAsString(items_all);
        content.append(JSON);
        content.append("}");
        resp.setContentType("text/plain; charset=UTF-8;");
        resp.getWriter().write(content.toString());
    }
}
