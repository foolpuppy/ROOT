package top.wigon.dao.impl;

import top.wigon.common.DBUtils;
import top.wigon.dao.ShopDAO;
import top.wigon.entity.Shop;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/25 22:48
 **/
public class ShopDAOImpl implements ShopDAO {
    private final String tableName = "tb_shop";

    @Override
    public Shop findByEntity(Shop shop) {
        return null;
    }

    @Override
    public Boolean addEntity(Shop shop) {
        Map<String, Object> valueMap = getValMap(shop);
        boolean flag = false;
        try {
            flag = DBUtils.insert(tableName, valueMap) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("店铺添加失败");
        }
        return flag;
    }

    @Override
    public boolean updateEntity(Shop shop) {
        boolean flag = false;
        try {
            flag = DBUtils.update(tableName, getValMap(shop), getPrimaryKey(shop)) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteEntity(Shop shop) {
        boolean flag = false;
        try {
            flag = DBUtils.delete(tableName, getPrimaryKey(shop)) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Map<String, Object> getValMap(Shop shop) {
        Map<String, Object> valueMap = new HashMap<>();
        valueMap.put("shop_id", shop.getShopId());
        valueMap.put("user_id", shop.getUserId());
        valueMap.put("shop_name", shop.getShopName());
        return valueMap;
    }

    @Override
    public Map<String, Object> getPrimaryKey(Shop shop) {
        Map<String, Object> pk = new HashMap<>();
        pk.put("shop_id", shop.getShopId());
        return pk;
    }
}
