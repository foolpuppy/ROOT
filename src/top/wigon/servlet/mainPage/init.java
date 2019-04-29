package top.wigon.servlet.mainPage;

import com.fasterxml.jackson.databind.ObjectMapper;
import top.wigon.entity.Item;
import top.wigon.service.impl.ItemServiceImpl;

import javax.servlet.ServletException;
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
public class init  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        ItemServiceImpl itemService=new ItemServiceImpl();
        //推荐产品
        List<Item> items_0f=itemService.findItemsByCategoryCols("电子产品",5);
        List<Item> items_1f=itemService.findItemsByCategory("衣橱服务");
        List<Item> items_2f= itemService.findItemsByCategory("生鲜水果");
        List<Item> items_3f=itemService.findItemsByCategory("美妆馆");

    }
}
