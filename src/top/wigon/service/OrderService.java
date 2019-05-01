package top.wigon.service;

import top.wigon.entity.Order;

import java.util.List;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/27 21:28
 **/
public interface OrderService {
    /**
     * 获取所有订单集合
     *
     * @return
     */
    List<Order> getAllOrders();

    /**
     * 删除对应订单号的订单
     *
     * @param order
     * @return
     */
    Boolean delOrder(Order order);

    /**
     * 根据Order_id 取到订单
     *
     * @param order_no
     * @return
     */
    Order getByOrderNo(String order_no);

    /**
     * 创建订单
     * @param order
     * @return
     */
    boolean createOrder(Order order);

    /**
     * 订单号获取Order_Item付款金额
     * @param order_no
     * @return
     */
    String getOrderItemTotalMoney(String order_no);
    /**
     * 订单号获取Order付款金额
     * @param order_no
     * @return
     */
    String getOrderTotalMoney(String order_no);
}
