package top.wigon.servlet.shop;

import top.wigon.entity.Item;
import top.wigon.service.impl.ItemServiceImpl;
import top.wigon.service.impl.UserServiceImpl;

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
@WebServlet("/itemAdd")
public class itemAdd extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ItemServiceImpl itemService = new ItemServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();
        Item item = new Item();
        item.setId(req.getParameter("itemId"));
        item.setTitle(req.getParameter("title"));
        item.setCategory(req.getParameter("category"));
        item.setPrice(new BigDecimal(req.getParameter("price")));
        item.setShopId(Integer.parseInt(userService.getShopIdByUserId(String.valueOf(req.getSession().getAttribute("user_id")))));
        item.setState(Integer.parseInt(req.getParameter("state")));
        item.setStock(Integer.parseInt(req.getParameter("stock")));
        itemService.itemAdd(item);
        itemService.updateItemImage("", item.getId());
        resp.setContentType("text/plain; charset=UTF-8;");
        resp.getWriter().write("添加成功");
    }
}
