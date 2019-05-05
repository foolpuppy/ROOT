package top.wigon.dao;

import top.wigon.entity.Order;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/25 19:06
 **/
public interface OrderDAO extends BaseDAO<Order> {
    boolean delUserOrder(String order_id, String user_id);
}
