package top.wigon.dao.impl;

import top.wigon.dao.ItemDescDAO;
import top.wigon.common.DBUtils;
import top.wigon.common.Pack2Entity;
import top.wigon.entity.ItemDesc;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/29 11:51
 **/
public class ItemDescImpl implements ItemDescDAO {
    private final String tableName = "tb_desc";

    @Override
    public ItemDesc findByEntity(ItemDesc itemDesc) {
        List<Map<String, Object>> result = null;
        try {
            result = DBUtils.query(tableName, getPrimaryKey(itemDesc));

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result != null) {
            //通过唯一ID查找 返回第一个
            return Pack2Entity.pack2ItemDesc(result).get(0);
        } else {
            return new ItemDesc();
        }
    }

    @Override
    public Boolean addEntity(ItemDesc itemDesc) {
        //todo 添加商品描述
        return false;
    }

    @Override
    public boolean updateEntity(ItemDesc itemDesc) {
        //更新商品描述
        boolean flag = false;
        try {
            flag = DBUtils.update(tableName, getValMap(itemDesc), getPrimaryKey(itemDesc)) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteEntity(ItemDesc itemDesc) {
        //删除商品描述
        boolean flag = false;
        try {
            flag = DBUtils.delete(tableName, getPrimaryKey(itemDesc)) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Map<String, Object> getValMap(ItemDesc itemDesc) {
        Map<String, Object> valueMap = new HashMap<>();
        if (itemDesc.getImagePath() != null) {
            valueMap.put("item_image_path", itemDesc.getImagePath());
        }
        if (itemDesc.getDesc() != null) {
            valueMap.put("item_desc", itemDesc.getDesc());
        }
        return valueMap;
    }

    @Override
    public Map<String, Object> getPrimaryKey(ItemDesc itemDesc) {
        Map<String, Object> pk = new HashMap<>();
        pk.put("item_id", itemDesc.getItemId());
        return pk;
    }
}
