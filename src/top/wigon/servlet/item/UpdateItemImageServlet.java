package top.wigon.servlet.item;

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
 * @date 2019/4/29 13:13
 **/
@WebServlet("/updateImage")
public class UpdateItemImageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO 处理文件上传
        //获得路径
        String path = "";
        //获得商品ID
        String item_id = req.getParameter("item_id");

        ItemServiceImpl itemServiceImplr = new ItemServiceImpl();
        resp.setContentType("text/plain; charset=UTF-8;");
        if (itemServiceImplr.updateItemImage(path, item_id)) {
            resp.getWriter().println("商品图片更新成功");
        } else {
            resp.getWriter().println("商品图片更新失败");
        }

    }
}
