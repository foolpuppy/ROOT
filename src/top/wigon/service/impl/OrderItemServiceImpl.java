package top.wigon.service.impl;

import top.wigon.dao.impl.OrderItemDAOImpl;
import top.wigon.entity.OrderItem;
import top.wigon.service.OrderItemService;

import java.util.List;

/**
 * @author L
 * @version 1.0
 * @date 2019/5/1 17:55
 **/
public class OrderItemServiceImpl implements OrderItemService {
    OrderItemDAOImpl dao = new OrderItemDAOImpl();

    @Override
    public boolean add(OrderItem orderItem) {
        return dao.addEntity(orderItem);
    }

    /**
     * 否无车内商品抓插入订单
     *
     * @param orderItemList
     */
    public void add(List<OrderItem> orderItemList) {
        orderItemList.forEach(item -> dao.addEntity(item));
    }
}
