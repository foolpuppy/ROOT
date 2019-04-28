package top.wigon.servlet.item;

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
 * @date 2019/4/26 9:49
 **/
@WebServlet("/addItem")
public class AddItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String itemId = req.getParameter("item_id");
        String itemTitle = req.getParameter("item_title");
        String itemCategory = req.getParameter("item_category");
        String itemPrice = req.getParameter("item_price");
        String itemStock = req.getParameter("item_stock");
        String itemState = req.getParameter("item_state");
        String shopId = req.getParameter("shop_id");
        Item item = new Item();
        item.setId(itemId);
        item.setTitle(itemTitle);
        item.setCategory(itemCategory);
        item.setPrice(new BigDecimal(itemPrice));
        item.setStock(Integer.parseInt(itemStock));
        item.setState(Integer.parseInt(itemState));
        item.setShopId(Integer.parseInt(shopId));
        ItemServiceImpl itemService = new ItemServiceImpl();
        boolean login = itemService.itemAdd(item);
        if (login) {
            //todo 商品添加成功
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {

            resp.sendRedirect("login.jsp");
        }
    }
}
