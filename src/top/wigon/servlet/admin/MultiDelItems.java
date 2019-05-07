package top.wigon.servlet.admin;

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
 * @date 2019/5/6 20:38
 **/
@WebServlet("/multiDelItems")
public class MultiDelItems extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] itemList = req.getParameterValues("arr[]");
        ItemServiceImpl itemService = new ItemServiceImpl();
        int cnt = 0;
        for (String item : itemList) {
            cnt += itemService.itemDel(item) ? 1 : 0;
        }
        resp.setContentType("text/plain; charset=UTF-8;");
        resp.getWriter().write("1");
    }
}
