package top.wigon.service.impl;

import top.wigon.dao.impl.OrderDAOImpl;
import top.wigon.entity.Order;
import top.wigon.service.OrderService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/27 21:30
 **/
public class OrderServiceImpl implements OrderService {
    private OrderDAOImpl dao = new OrderDAOImpl();

    @Override
    public List<Order> getAllOrders() {
        return dao.getAllOrders();
    }

    @Override
    public Boolean delOrder(Order order) {
        return dao.deleteEntity(order);
    }

    @Override
    public Order getByOrderNo(String order_no) {
        return dao.getByOrderNo(order_no);
    }

    @Override
    public boolean createOrder(Order order) {
        return dao.addEntity(order);
    }

    @Override
    public String getOrderItemTotalMoney(String order_no) {
        String money = "0";
        try {
            money = dao.getItemOrderTotalMoney(order_no);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return money;
    }

    @Override
    public String getOrderTotalMoney(String order_no) {
        String money = "0";
        try {
            money = dao.getOrderTotalMoney(order_no);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return money;
    }

    @Override
    public boolean updateOrderState(String order_id, int state) {
        boolean flag = false;
        try {
            flag = dao.updateOrderState(order_id, state);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public Boolean delUserOrder(String order_id, String user_id) {
        return dao.delUserOrder(order_id, user_id);
    }

    public Boolean delOrderByOrderId(String orderId) {
        Order order = new Order();
        order.setOrderId(orderId);
        return dao.deleteEntity(order);
    }

    public List<Order> getMyOrders(String userId, Map<String, Object> whereMap, int page, int limit) {
        return dao.getMyOrders(userId, whereMap, page, limit);
    }

    public List<Order> getMyOrders(String userId, int page, int limit) {
        return dao.getMyOrders(userId, page, limit);
    }

    public List<Order> getAllOrders(Map<String, Object> whereMap, int page, int limit) {
        return dao.getAllOrders(whereMap, page, limit);
    }

    public List<Order> getAllOrders(int page, int limit) {
        return dao.getAllOrders(page, limit);


    }
}
