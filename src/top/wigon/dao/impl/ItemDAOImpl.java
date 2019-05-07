package top.wigon.dao.impl;

import top.wigon.common.DBUtils;
import top.wigon.common.Pack2Entity;
import top.wigon.dao.ItemDAO;
import top.wigon.entity.Item;

import java.sql.SQLException;
import java.util.*;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/25 19:13
 **/
public class ItemDAOImpl implements ItemDAO {

    private final String tableName = "tb_item";
    private final String ITEM_JOIN_DESC = "SELECT t1.id,t2.item_id,t2.item_title,t1.item_image_path,t2.item_category,t1.item_desc,t2.item_price,t2.item_stock,t2.item_state,t2.shop_id,t2.gmt_create,t2.gmt_modified FROM tb_item t2 LEFT JOIN tb_desc t1 ON t1.item_id = t2.item_id and t2.item_state=1";
    private final String DAILY_RECOMMEND = "SELECT t1.id,t2.item_id,t2.item_title,t1.item_image_path,t2.item_category,t1.item_desc,t2.item_price,t2.item_stock,t2.item_state,t2.shop_id,t2.gmt_create,t2.gmt_modified FROM tb_item t2 LEFT JOIN tb_desc t1 ON t1.item_id = t2.item_id WHERE t2.item_price < ? and t2.item_price> ? and t2.item_state=1 Limit ?";
    private final String GET_MY_ITEMS = "SELECT t1.id,t2.item_id,t2.item_title,t1.item_image_path,t2.item_category,t1.item_desc,t2.item_price,t2.item_stock,t2.item_state,t2.shop_id FROM tb_item t2 LEFT JOIN tb_desc t1 ON t1.item_id = t2.item_id and t2.item_state=1 WHERE shop_id=(SELECT shop_id from tb_shop where user_id=?)";
    private final String GET_ALL_ITEMS = "SELECT t2.item_id,t2.item_title,t1.item_image_path,t2.item_category,t1.item_desc,t2.item_price,t2.item_stock,t2.item_state,t2.shop_id FROM tb_item t2 LEFT JOIN tb_desc t1 ON t1.item_id = t2.item_id ";

    @Override
    public Item findByEntity(Item item) {
        List<Map<String, Object>> result = null;
        try {
            result = DBUtils.queryMult(ITEM_JOIN_DESC, getPrimaryKey(item));

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result != null && result.size() > 0) {
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

    /**
     * 条件查询
     *
     * @param keyword
     * @return
     */
    public List<Item> findByCondition(Map<String, Object> keyword) {
        List<Item> items = new ArrayList<>();
        try {
            List<Map<String, Object>> result = DBUtils.queryLikeMultLimit(ITEM_JOIN_DESC, keyword, false);

            items = Pack2Entity.pack2items(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    /**
     * 限制返回行数
     *
     * @param keyword
     * @param cols
     * @return
     */
    public List<Item> findByConditionCols(Map<String, Object> keyword, int cols) {
        List<Item> items = new ArrayList<>();
        try {
            List<Map<String, Object>> result = DBUtils.queryLikeMultLimit(ITEM_JOIN_DESC, keyword, cols);

            items = Pack2Entity.pack2items(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    /**
     * 价格限制查询 限制返回条数
     */

    public List<Item> getDailyRecommend(int highPrice, int lowPrice, int cols) {
        List<Item> items = new ArrayList<>();
        try {
            List<Map<String, Object>> result = DBUtils.executeQuery(DAILY_RECOMMEND, new Object[]{highPrice, lowPrice
                    , cols});

            items = Pack2Entity.pack2items(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    /**
     * 返回所有商品
     *
     * @return
     */
    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        try {
            List<Map<String, Object>> result = DBUtils.query(ITEM_JOIN_DESC);
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

    /**
     * 通过UserId 分页查询
     *
     * @param userId
     * @param page
     * @param limit
     * @return
     */
    public List<Item> getMyItems(String userId, int page, int limit) {
        List<Item> items = new ArrayList<>();
        try {
            StringBuilder SQL = new StringBuilder();
            SQL.append(GET_MY_ITEMS.replace("?", userId));
            SQL.append("limit " + (page == -1 ? 100 : (page - 1) * limit + " , " + limit));
            List<Map<String, Object>> result = DBUtils.executeQuery(SQL.toString(), null);
            items = Pack2Entity.pack2items(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    /**
     * 通过UserId 模糊 分页查询
     *
     * @param userId
     * @param whereMap
     * @param page
     * @param limit
     * @return
     */
    public List<Item> getMyItems(String userId, Map<String, Object> whereMap, int page, int limit) {
        List<Item> items = new ArrayList<>();
        try {
            StringBuilder SQL = new StringBuilder();
            SQL.append(GET_MY_ITEMS.replace("?", userId));
            if (whereMap != null && whereMap.size() > 0) {
                Iterator<String> iterator = whereMap.keySet().iterator();
                //i=1就 会从第一个WherMap 开始 添加条件
                int i = 1;
                while (iterator.hasNext()) {
                    String key = iterator.next();
                    SQL.append(i == 0 ? " where " : " ");
                    SQL.append(i == 0 || i == 1 ? " and ( " : " OR ");
                    SQL.append(key + " like '%" + whereMap.get(key) + "%'");
                    i++;
                }
                SQL.append(") LIMIT " + (page == -1 ? 100 : (page - 1) * limit + " , " + limit));
                List<Map<String, Object>> result = DBUtils.executeQuery(SQL.toString(), null);
                items = Pack2Entity.pack2items(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    /**
     * 条件模糊查询
     *
     * @param whereMap
     * @param page
     * @param limit
     * @return
     */
    public List<Item> getAllItems(Map<String, Object> whereMap, int page, int limit) {
        List<Item> items = new ArrayList<>();
        try {
            StringBuilder SQL = new StringBuilder();
            SQL.append(GET_ALL_ITEMS);
            if (whereMap != null && whereMap.size() > 0) {
                Iterator<String> iterator = whereMap.keySet().iterator();
                //i=1就 会从第一个WherMap 开始 添加条件
                int i = 0;
                while (iterator.hasNext()) {
                    String key = iterator.next();
                    SQL.append(i == 0 ? " where " : " ");
                    SQL.append(i == 0 ? " " : " OR ");
                    SQL.append(key + " like '%" + whereMap.get(key) + "%'");
                    i++;
                }
                SQL.append("LIMIT " + (page == -1 ? limit : (page - 1) * limit + " , " + limit));
                List<Map<String, Object>> result = DBUtils.executeQuery(SQL.toString(), null);
                items = Pack2Entity.pack2items(result);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    /**
     * 分页查询所有商品
     *
     * @param page
     * @param limit
     * @return
     */
    public List<Item> getAllItems(int page, int limit) {
        List<Item> users = new ArrayList<>();
        try {
            List<Map<String, Object>> result = DBUtils.executeQuery(GET_ALL_ITEMS + " Limit " + (page == -1 ? 100 : (page - 1) * limit + " , " + limit), null);
            users = Pack2Entity.pack2items(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
