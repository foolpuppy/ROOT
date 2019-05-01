package top.wigon.service.impl;

import top.wigon.DAO.impl.OrderDAOImpl;
import top.wigon.entity.Order;
import top.wigon.service.OrderService;

import java.util.List;

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

}
