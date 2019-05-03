package top.wigon.service;

import top.wigon.entity.Package;
import top.wigon.entity.Shipping;

import java.util.List;

/**
 * @author L
 * @version 1.0
 * @date 2019/5/2 21:55
 **/
public interface ShippingService {
    /**
     * 添加物流信息
     *
     * @param shipping
     * @return
     */
    Boolean add(Shipping shipping);

    /**
     * 订单号取物流信息
     *
     * @param order_id
     * @return
     */
    List<Package> getShippingInfoByOrderId(String order_id);

    List<Package> getShippingInfoByUserId(String order_id);
}
