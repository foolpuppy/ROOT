package top.wigon.servlet.payment;

import top.wigon.entity.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/28 13:32
 **/
@WebServlet("/CreateOrder")
public class CreateOrder extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO 根据购物车信息 创建订单到 数据库
        //参数
        Order order = new Order();
    }
}
