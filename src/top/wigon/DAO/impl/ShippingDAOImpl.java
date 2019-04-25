package top.wigon.DAO.impl;

import top.wigon.DAO.ShippingDAO;
import top.wigon.common.DBUtils;
import top.wigon.entity.Shipping;

import java.sql.SQLException;
import java.util.HashMap;
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
        Map<String, Object> valueMap = getValMap(shipping);
        boolean flag = false;
        try {
            flag = DBUtils.insert(tableName, valueMap) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("物流信息添加失败");
        }
        return flag;
    }

    @Override
    public boolean updateEntity(Shipping shipping) {
        boolean flag = false;
        try {
            flag = DBUtils.update(tableName, getValMap(shipping), getPrimaryKey(shipping)) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteEntity(Shipping shipping) {
        boolean flag = false;
        try {
            flag = DBUtils.delete(tableName, getPrimaryKey(shipping)) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Map<String, Object> getValMap(Shipping shipping) {
        Map<String, Object> valueMap = new HashMap<>();
        valueMap.put("id", shipping.getId());
        valueMap.put("order_id", shipping.getOrderId());
        valueMap.put("receiver_name", shipping.getReceiverName());
        valueMap.put("receiver_tel", shipping.getReceiverTel());
        valueMap.put("receiver_state", shipping.getReceiverState());
        valueMap.put("receiver_city", shipping.getReceiverCity());
        valueMap.put("receiver_district", shipping.getReceiverDistrict());
        valueMap.put("receiver_address", shipping.getReceiverAddress());
        valueMap.put("receiver_zip", shipping.getReceiverZip());
        return valueMap;
    }

    @Override
    public Map<String, Object> getPrimaryKey(Shipping shipping) {
        Map<String, Object> pk = new HashMap<>();
        pk.put("id", shipping.getId());
        return pk;
    }
}
