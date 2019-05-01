package top.wigon.servlet.cart;

import top.wigon.common.CartUtil;
import top.wigon.entity.CartInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/30 11:45
 **/
@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String item_id = req.getParameter("item_id");
        String item_num = req.getParameter("item_num");
        Cookie cookie = CartUtil.getCookie(req);
        List<CartInfo> cartInfos = new ArrayList<>();
//        CartInfo info = new CartInfo(item_num, Integer.parseInt(item_id));
//        cartInfos.add(info);
        cookie.setValue(CartUtil.setCookiesVal(cartInfos));
        resp.addCookie(cookie);
        resp.sendRedirect("index.html");
    }
}
