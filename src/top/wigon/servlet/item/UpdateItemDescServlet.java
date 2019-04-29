package top.wigon.servlet.item;

import top.wigon.DAO.impl.ItemDescImpl;
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
 * @date 2019/4/29 11:46
 **/
@WebServlet("/updateItemDesc")
public class UpdateItemDescServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String item_id = req.getParameter("item_id");
        String item_desc = req.getParameter("desc");
        ItemServiceImpl itemServiceImplr = new ItemServiceImpl();
        resp.setContentType("text/plain; charset=UTF-8;");
        if (itemServiceImplr.updateItemDesc(item_desc, item_id)) {
            resp.getWriter().println("商品描述更新成功");
        } else {
            resp.getWriter().println("商品描述更新失败");
        }
    }
}
