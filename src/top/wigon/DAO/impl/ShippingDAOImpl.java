package top.wigon.DAO.impl;

import top.wigon.DAO.ShippingDAO;
import top.wigon.entity.Shipping;

import java.util.Map;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/25 22:48
 **/
public class ShippingDAOImpl implements ShippingDAO {
    private final String tableName = "tb_shipping";
    @Override
    public Shipping findByEntity(Shipping shipping) {
        return null;
    }

    @Override
    public Boolean addEntity(Shipping shipping) {
        return null;
    }

    @Override
    public boolean updateEntity(Shipping shipping) {
        return false;
    }

    @Override
    public boolean deleteEntity(Shipping shipping) {
        return false;
    }

    @Override
    public Map<String, Object> getValMap(Shipping shipping) {
        return null;
    }

    @Override
    public Map<String, Object> getPrimaryKey(Shipping shipping) {
        return null;
    }
}
