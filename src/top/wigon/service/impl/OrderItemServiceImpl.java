package top.wigon.service.impl;

import top.wigon.DAO.impl.OrderItemDAOImpl;
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

    public void add(List<OrderItem> orderItemList) {
        orderItemList.forEach(item -> dao.addEntity(item));
    }
}
