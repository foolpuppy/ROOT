package top.wigon.servlet.admin;

import top.wigon.entity.Item;
import top.wigon.service.impl.ItemServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author L
 * @version 1.0
 * @date 2019/5/6 12:00
 **/
@WebServlet("/itemEdit")
public class ItemEdit extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String itemDesc = req.getParameter("desc");
        String title = req.getParameter("title");
        String imagePath = req.getParameter("itemImagePath");
        String price = req.getParameter("price");
        String stock = req.getParameter("stock");
        String state = req.getParameter("state");
        String itemId = req.getParameter("id");
        String shopId = req.getParameter("shopId");
        String category = req.getParameter("category");
        Item item = new Item();
        //ItemId为只读字段
        item.setId(itemId);
        if (title != null) {
            item.setTitle(title);
        }
        if (shopId != null) {
            item.setShopId(Integer.parseInt(shopId));
        }
        if (category != null) {
            item.setCategory(category);
        }
        if (price != null) {
            item.setPrice(new BigDecimal(price));
        }
        if (stock != null) {
            item.setStock(Integer.parseInt(stock));
        }
        if (state != null) {
            item.setState(Integer.parseInt(state));
        }
        ItemServiceImpl itemService = new ItemServiceImpl();
        itemService.updateItem(item);
        if (itemDesc != null) {
            itemService.updateItemDesc(itemDesc, itemId);
        }
        if (imagePath != null) {
            itemService.updateItemImage(imagePath, itemId);
        }
        resp.setContentType("text/plain; charset=UTF-8;");
        resp.getWriter().write("1");
    }
}
