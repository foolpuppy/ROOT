package top.wigon.servlet.payment;

import top.wigon.common.DBUtils;
import top.wigon.entity.Order;
import top.wigon.entity.OrderItem;
import top.wigon.service.impl.ItemServiceImpl;
import top.wigon.service.impl.OrderItemServiceImpl;
import top.wigon.service.impl.OrderServiceImpl;
import top.wigon.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
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
        UserServiceImpl userService = new UserServiceImpl();
        try {
            if (userService.getUserOrderUnPaidNumByUserId(String.valueOf(req.getSession().getAttribute("user_id"))) == 0) {
                // 创建订单
                Order order = new Order();
                order.setOrderId(DBUtils.getCurrentTimeMillis());
                order.setOrderCreateTime(DBUtils.getCurrDateTime());
                order.setUserId((String) req.getSession().getAttribute("user_id"));
                order.setCreateTime(DBUtils.getCurrDateTime());
                OrderServiceImpl orderService = new OrderServiceImpl();
                ItemServiceImpl itemService = new ItemServiceImpl();
                List<OrderItem> cartItem = new ArrayList<>();
                OrderItem item;
                //单个商品
                if (req.getParameter("id") != null && req.getParameter("number") != null && req.getParameter("id") != null) {
                    item = new OrderItem();
                    item.setItemId(Integer.parseInt(req.getParameter("id")));
                    item.setTitle(req.getParameter("title"));
                    item.setNum(Integer.parseInt(req.getParameter("number")));
                    item.setOrderId(order.getOrderId());
                    item.setPrice(new BigDecimal(itemService.getItemPriceById(req.getParameter("id"))));

                    cartItem.add(item);
                } else {
                    String[] res = req.getParameterValues("goodsList");
                    for (String re : res) {
                        item = new OrderItem();
                        item.setItemId(Integer.parseInt(re.split(",")[0]));
                        item.setTitle(re.split(",")[1]);
                        item.setNum(Integer.parseInt(re.split(",")[2]));
                        item.setOrderId(order.getOrderId());
                        item.setPrice(new BigDecimal(itemService.getItemPriceById(re.split(",")[0])));
                        cartItem.add(item);
                    }
                }
                //创建订单同时 触发器插入了数据到物流表
                boolean flag = orderService.createOrder(order);
                //订单创建完成吧订单号存入session
                if (flag) {
                    req.getSession().removeAttribute("order_no");
                    req.getSession().setAttribute("order_no", order.getOrderId());
                    OrderItemServiceImpl orderItemService = new OrderItemServiceImpl();
                    orderItemService.add(cartItem);
                    //跳转到用户信息界面
//                    resp.sendRedirect("confirm_orders.html");
                    resp.setContentType("text/plain; charset=UTF-8;");
                    resp.getWriter().write("0");
                }
            } else {
                resp.setContentType("text/plain; charset=UTF-8;");
                resp.getWriter().write("1");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
