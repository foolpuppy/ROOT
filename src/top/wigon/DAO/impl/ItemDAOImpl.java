package top.wigon.DAO.impl;

import top.wigon.DAO.ItemDAO;
import top.wigon.common.DBUtils;
import top.wigon.common.Pack2Entity;
import top.wigon.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/25 19:13
 **/
public class ItemDAOImpl implements ItemDAO {
    private final String tableName = "tb_item";

    @Override
    public Item findByEntity(Item item) {
        List<Map<String, Object>> result = null;
        try {
            result = DBUtils.query(tableName, getPrimaryKey(item));

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result != null) {
            //通过唯一ID查找 返回第一个
            return Pack2Entity.pack2items(result).get(0);
        } else {
            return new Item();
        }
    }

    @Override
    public Boolean addEntity(Item item) {
        Map<String, Object> valueMap = getValMap(item);
        boolean flag = false;
        try {
            flag = DBUtils.insert(tableName, valueMap) > 0;
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
            flag = DBUtils.update(tableName, getValMap(item), getPrimaryKey(item)) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteEntity(Item item) {
        boolean flag = false;
        try {
            flag = DBUtils.delete(tableName, getPrimaryKey(item)) == 1;
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

    public List<Item> findByCondition(Map<String, Object> keyword) {
        List<Item> items = new ArrayList<>();
        try {
            List<Map<String, Object>> result = DBUtils.queryLike(tableName, keyword);

            items = Pack2Entity.pack2items(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        try {
            List<Map<String, Object>> result = DBUtils.query("SELECT\n" +
                    "\tt1.id,\n" +
                    "\tt2.item_id,\n" +
                    "\tt2.item_title,\n" +
                    "\tt1.item_image_path,\n" +
                    "\tt2.item_category,\n" +
                    "\tt2.item_price,\n" +
                    "\tt2.item_stock,\n" +
                    "\tt2.item_state,\n" +
                    "\tt2.shop_id,\n" +
                    "\tt2.gmt_create,\n" +
                    "\tt2.gmt_modified \n" +
                    "FROM\n" +
                    "\t`tb_item` t2\n" +
                    "\tLEFT JOIN tb_desc t1 ON t1.item_id = t2.item_id");
            items = Pack2Entity.pack2items(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    /**
     * 获取条件查询的MAP
     *
     * @param item
     * @return
     */
    public Map<String, Object> getConditionValMap(Item item) {
        Map<String, Object> vmap = new HashMap<>();
        if (item.getTitle() != null && !item.getTitle().isEmpty()) {
            vmap.put("item_title", item.getTitle());
        }
        if (item.getCategory() != null && !item.getCategory().isEmpty()) {
            vmap.put("item_category", item.getCategory());
        }
        return vmap;

    }
}
