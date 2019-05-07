package top.wigon.dao.impl;

import top.wigon.common.DBUtils;
import top.wigon.common.Pack2Entity;
import top.wigon.dao.ShippingDAO;
import top.wigon.entity.Package;
import top.wigon.entity.Shipping;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/25 22:48
 **/
public class ShippingDAOImpl implements ShippingDAO {
    private final String tableName = "tb_shipping";
    private final String QUERY_SHIPPING_INFO_BY_USERID = "SELECT\ttb_order.order_id,tb_order.order_state,\ttb_order.user_id,\ttb_order.payment,\ttb_order.shipping_name,\ttb_order.shipping_code,\ttb_order.gmt_create,\ttb_order.gmt_modified,\ttb_order_item.item_num,\ttb_item.item_category,\ttb_order_item.item_title,\ttb_order_item.item_price,\ttb_order_item.total_fee,\ttb_order_item.item_id,\ttb_desc.item_image_path ,  tb_shipping.current_location FROM\ttb_order\tLEFT JOIN tb_order_item ON tb_order.order_id = tb_order_item.order_id\tJOIN tb_desc ON tb_order_item.item_id = tb_desc.item_id\tJOIN tb_item ON tb_order_item.item_id = tb_item.item_id \tleft JOIN tb_shipping on tb_shipping.order_id=tb_order.order_id WHERE\ttb_order.order_id IN ( SELECT order_id FROM tb_order WHERE user_id = ? ) and tb_order.order_state !=1";
    private final String QUERY_SHIPPING_INFO_BY_ORDERID = "SELECT\ttb_order.order_id,tb_order.order_state,\ttb_order.user_id,\ttb_order.payment,\ttb_order.shipping_name,\ttb_order.shipping_code,\ttb_order.gmt_create,\ttb_order.gmt_modified,\ttb_order_item.item_num,\ttb_item.item_category,\ttb_order_item.item_title,\ttb_order_item.item_price,\ttb_order_item.total_fee,\ttb_order_item.item_id,\ttb_desc.item_image_path ,  tb_shipping.current_location FROM\ttb_order\tLEFT JOIN tb_order_item ON tb_order.order_id = tb_order_item.order_id\tJOIN tb_desc ON tb_order_item.item_id = tb_desc.item_id\tJOIN tb_item ON tb_order_item.item_id = tb_item.item_id \tleft JOIN tb_shipping on tb_shipping.order_id=tb_order.order_id WHERE\ttb_order.order_id =? and tb_order.order_state !=1";

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
        Map<String, Object> keyMap = new HashMap<>();
        keyMap.put("order_id", shipping.getOrderId());
        try {
            flag = DBUtils.update(tableName, getValMap(shipping), keyMap) == 1;
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
        valueMap.put("order_id", shipping.getOrderId());
        valueMap.put("receiver_name", shipping.getReceiverName());
        valueMap.put("receiver_tel", shipping.getReceiverTel());
        valueMap.put("receiver_state", shipping.getReceiverState());
        valueMap.put("receiver_city", shipping.getReceiverCity());
        valueMap.put("receiver_district", shipping.getReceiverDistrict());
        valueMap.put("receiver_address", shipping.getReceiverAddress());
        valueMap.put("receiver_zip", shipping.getReceiverZip());
        if (shipping.getCurrLoc() != null) {
            valueMap.put("current_location", shipping.getCurrLoc());
        }
        return valueMap;
    }

    @Override
    public Map<String, Object> getPrimaryKey(Shipping shipping) {
        Map<String, Object> pk = new HashMap<>();
        pk.put("id", shipping.getId());
        return pk;
    }

    @Override
    public List<Package> getShippingInfoByOrderId(String order_id) {
        List<Package> items = new ArrayList<>();
        try {
            List<Map<String, Object>> result = DBUtils.executeQuery(QUERY_SHIPPING_INFO_BY_ORDERID, new Object[]{order_id});
            items = Pack2Entity.pack2Packages(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public List<Package> getShippingInfoByUserId(String user_id) {
        List<Package> items = new ArrayList<>();
        try {
            List<Map<String, Object>> result = DBUtils.executeQuery(QUERY_SHIPPING_INFO_BY_USERID, new Object[]{user_id});
            items = Pack2Entity.pack2Packages(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }
}
