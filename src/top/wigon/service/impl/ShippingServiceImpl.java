package top.wigon.service.impl;

import top.wigon.DAO.impl.ShippingDAOImpl;
import top.wigon.entity.Shipping;
import top.wigon.service.ShippingService;

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
}
