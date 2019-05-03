package top.wigon.DAO;

import top.wigon.entity.Package;
import top.wigon.entity.Shipping;

import java.util.List;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/25 19:08
 **/
public interface ShippingDAO extends BaseDAO<Shipping> {
    /**
     * 获取物流信息通过订单号
     *
     * @param order_id
     * @return
     */

    List<Package> getShippingInfoByOrderId(String order_id);

    /**
     * 获取物流信息通过用户ID
     *
     * @param user_id
     * @return
     */
    List<Package> getShippingInfoByUserId(String user_id);
}
