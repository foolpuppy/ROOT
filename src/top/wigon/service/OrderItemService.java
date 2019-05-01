package top.wigon.service;

import top.wigon.entity.OrderItem;

/**
 * @author L
 * @version 1.0
 * @date 2019/5/1 17:13
 **/
public interface OrderItemService {
    /**
     * 添加
     * @param orderItem
     * @return
     */
    boolean add(OrderItem orderItem);
}
