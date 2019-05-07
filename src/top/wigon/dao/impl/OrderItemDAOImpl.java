package top.wigon.dao.impl;

import top.wigon.common.DBUtils;
import top.wigon.dao.OrderItemDAO;
import top.wigon.entity.OrderItem;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author L
 * @version 1.0
 * @date 2019/5/1 17:48
 **/
public class OrderItemDAOImpl implements OrderItemDAO {
    private final String tableName = "tb_order_item";
    private final String QUERY_PRICE_BY_ID = "SELECT item_price FROM `tb_item` where item_id=?";

    @Override
    public OrderItem findByEntity(OrderItem orderItem) {
        return null;
    }

    @Override
    public Boolean addEntity(OrderItem orderItem) {
        Map<String, Object> valueMap = getValMap(orderItem);
        boolean flag = false;
        try {
            flag = DBUtils.insert(tableName, valueMap) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("添加失败");
        }
        return flag;
    }

    @Override
    public boolean updateEntity(OrderItem orderItem) {
        return false;
    }

    @Override
    public boolean deleteEntity(OrderItem orderItem) {
        return false;
    }

    @Override
    public Map<String, Object> getValMap(OrderItem orderItem) {
        Map<String, Object> valueMap = new HashMap<>();
        valueMap.put("item_id", orderItem.getItemId());
        valueMap.put("order_id", orderItem.getOrderId());
        valueMap.put("item_num", orderItem.getNum());
        valueMap.put("item_title", orderItem.getTitle());
        valueMap.put("item_price", orderItem.getPrice());
        valueMap.put("total_fee", orderItem.getTotalFee());
        return valueMap;
    }

    @Override
    public Map<String, Object> getPrimaryKey(OrderItem orderItem) {
        return null;
    }
}
