package top.wigon.DAO.impl;

import top.wigon.DAO.ShopDAO;
import top.wigon.entity.Shop;

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
        return null;
    }

    @Override
    public boolean updateEntity(Shop shop) {
        return false;
    }

    @Override
    public boolean deleteEntity(Shop shop) {
        return false;
    }

    @Override
    public Map<String, Object> getValMap(Shop shop) {
        return null;
    }

    @Override
    public Map<String, Object> getPrimaryKey(Shop shop) {
        return null;
    }
}
