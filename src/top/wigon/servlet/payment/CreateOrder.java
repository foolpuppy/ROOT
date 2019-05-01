package top.wigon.servlet.payment;

import org.junit.jupiter.api.Test;
import top.wigon.common.DBUtils;
import top.wigon.entity.Order;
import top.wigon.entity.OrderItem;
import top.wigon.service.impl.OrderItemServiceImpl;
import top.wigon.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/28 13:32
 **/
@WebServlet("/CreateOrder")
public class CreateOrder extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO 根据购物车信息(商品ID+商品数量+商品标题) 创建订单到 数据库
        // 创建订单
        Order order = new Order();
        order.setOrderId(DBUtils.getCurrentTimeMillis());
        order.setOrderCreateTime(DBUtils.getCurrDateTime());
        order.setUserId((String) req.getSession().getAttribute("user_id"));
        order.setCreateTime(DBUtils.getCurrDateTime());
        OrderServiceImpl orderService = new OrderServiceImpl();
        List<OrderItem> cartItem = new ArrayList<>();

        boolean flag = orderService.createOrder(order);
        //订单创建完成吧订单号存入session
        if (flag) {
            req.getSession().setAttribute("order_no", order.getOrderId());
            //todo 商品加入到数据库
            OrderItemServiceImpl orderItemService = new OrderItemServiceImpl();
            orderItemService.add(cartItem);
            //跳转到用户信息界面
            resp.sendRedirect("consumer_center.html");
        }
    }

    @Test
    void test() {
        Order order = new Order();
        order.setOrderId(DBUtils.getCurrentTimeMillis());
        order.setOrderCreateTime(DBUtils.getCurrDateTime());
        order.setUserId("1000");
        order.setPaymentType(1);
        order.setCreateTime(DBUtils.getCurrDateTime());
        OrderServiceImpl orderService = new OrderServiceImpl();
        boolean flag = orderService.createOrder(order);
    }
}
