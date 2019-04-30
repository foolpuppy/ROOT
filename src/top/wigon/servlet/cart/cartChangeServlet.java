package top.wigon.servlet.cart;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/26 16:25
 **/
@WebServlet("/cartchange")
public class cartChangeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String item_id = req.getParameter("goodsid");
        String item_price = req.getParameter("unitprice");
        String item_num = req.getParameter("count");
        if (req.getParameterMap().size() == 1) {
            //todo 删除ItemId的数量
        }
        if (req.getParameterMap().size() == 3) {
            //TODO 购物车商品信息变化
        }
        String res = item_id + item_price + item_num;
        System.err.println(item_id + item_price + item_num);
        resp.setContentType("text/plain");
        resp.getWriter().write(res);
    }
}
