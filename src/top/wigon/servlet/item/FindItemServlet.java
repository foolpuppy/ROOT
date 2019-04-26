package top.wigon.servlet.item;

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
 * @date 2019/4/26 13:05
 **/
@WebServlet("/findItemByConditions")
public class FindItemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String item_title;
        item_title = req.getParameter("item_title");
        String item_category;
        item_category = req.getParameter("item_category");
        System.err.println(item_title + " " + item_category);
        Item item = new Item();
        item.setTitle(item_title);
        item.setCategory(item_category);
        ItemServiceImpl itemService = new ItemServiceImpl();
        //返回模糊查询的商品集合
        List<Item> items = itemService.findItemsByName(item);
        boolean login = items.size() > 0;
        if (login) {


            resp.getWriter().println("条件查询成功," + items.size());
        } else {


            resp.getWriter().println("无结果");
        }
    }
}
