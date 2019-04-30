package top.wigon.servlet.cart;

import top.wigon.common.CartUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/30 13:34
 **/
@WebServlet("/delCart")
public class DelCart extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = CartUtil.getCookie(req);
        // 设置寿命为0秒
        cookie.setMaxAge(0);
        // 设置路径
        cookie.setPath("/");
        // 设置cookie的value为null
        cookie.setValue(null);
        // 更新cookie
        resp.addCookie(cookie);
        //TODO 清空购物车
    }
}
