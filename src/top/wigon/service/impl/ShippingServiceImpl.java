package top.wigon.service.impl;

import top.wigon.dao.impl.ShippingDAOImpl;
import top.wigon.entity.Package;
import top.wigon.entity.Shipping;
import top.wigon.service.ShippingService;

import java.util.List;

/**
 * @author L
 * @version 1.0
 * @date 2019/5/2 21:56
 **/
public class ShippingServiceImpl implements ShippingService {
    ShippingDAOImpl dao = new ShippingDAOImpl();

    @Override
    public Boolean add(Shipping shipping) {
        return dao.addEntity(shipping);
    }

    @Override
    public Boolean update(Shipping shipping) {
        return dao.updateEntity(shipping);
    }

    @Override
    public List<Package> getShippingInfoByOrderId(String order_id) {
        return dao.getShippingInfoByOrderId(order_id);
    }

    @Override
    public List<Package> getShippingInfoByUserId(String user_id) {
        return dao.getShippingInfoByUserId(user_id);
    }
}
