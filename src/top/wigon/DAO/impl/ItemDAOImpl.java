package top.wigon.DAO.impl;

import top.wigon.DAO.ItemDAO;
import top.wigon.common.DBUtils;
import top.wigon.common.Pack2Entity;
import top.wigon.entity.Item;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/25 19:13
 **/
public class ItemDAOImpl implements ItemDAO {
    @Override
    public Item findByEntity(Item item) {
        List<Map<String, Object>> result = null;
        try {
            result = DBUtils.query("tb_user", getPrimaryKey(item));

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result != null) {
            return Pack2Entity.pack2item(result);
        } else {
            return new Item();
        }
    }

    @Override
    public Boolean addEntity(Item item) {
        Map<String, Object> valueMap = getValMap(item);
        boolean flag = false;
        try {
            flag = DBUtils.insert("tb_item", valueMap) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("商品添加失败");
        }
        return flag;

    }

    @Override
    public boolean updateEntity(Item item) {
        boolean flag = false;
        try {
            flag = DBUtils.update("tb_item", getValMap(item), getPrimaryKey(item)) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteEntity(Item item) {
        boolean flag = false;
        try {
            flag = DBUtils.delete("tb_item", getPrimaryKey(item)) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Map<String, Object> getValMap(Item item) {
        Map<String, Object> valueMap = new HashMap<>();
        valueMap.put("item_id", item.getId());
        valueMap.put("item_title", item.getTitle());
        valueMap.put("item_category", item.getCategory());
        valueMap.put("item_price", item.getPrice());
        valueMap.put("item_stock", item.getStock());
        valueMap.put("item_state", item.getState());
        valueMap.put("shop_id", item.getShopId());
        return valueMap;
    }

    @Override
    public Map<String, Object> getPrimaryKey(Item item) {
        Map<String, Object> pk = new HashMap<>();
        pk.put("item_id", item.getId());
        return pk;
    }
}
