package top.wigon.service;

import top.wigon.entity.Shipping;

/**
 * @author L
 * @version 1.0
 * @date 2019/5/2 21:55
 **/
public interface ShippingService {
    /**
     * 添加物流信息
     * @param shipping
     * @return
     */
    Boolean add(Shipping shipping);
}
