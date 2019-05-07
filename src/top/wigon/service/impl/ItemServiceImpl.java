package top.wigon.service.impl;

import top.wigon.dao.impl.ItemDAOImpl;
import top.wigon.dao.impl.ItemDescImpl;
import top.wigon.entity.Item;
import top.wigon.entity.ItemDesc;
import top.wigon.service.ItemService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/26 9:57
 **/
public class ItemServiceImpl implements ItemService {
    private ItemDAOImpl dao = new ItemDAOImpl();
    private ItemDescImpl Ddao = new ItemDescImpl();

    @Override
    public Boolean itemAdd(Item item) {
        return dao.addEntity(item);
    }

    @Override
    public Boolean itemDel(String itemId) {
        Item item = new Item();
        item.setId(itemId);
        return dao.deleteEntity(item);
    }

    @Override
    public List<Item> findItemsByName(Item item) {
        Map<String, Object> keyword = dao.getConditionValMap(item);
        return dao.findByCondition(keyword);
    }

    @Override
    public List<Item> findItemsByCategoryCols(String category, int cols) {
        Map<String, Object> keyword = new HashMap<>();
        keyword.put("item_category", category);
        keyword.put("item_state", 1);
        List<Item> result = dao.findByConditionCols(keyword, cols);
        return result;
    }

    @Override
    public List<Item> findItemsByCategory(String category) {
        Map<String, Object> keyword = new HashMap<>();
        keyword.put("item_category", category);
        return dao.findByCondition(keyword);
    }

    @Override
    public List<Item> findItemsByPrice(int hPrice, int lPrice, int cols) {
        return dao.getDailyRecommend(hPrice, lPrice, cols);
    }

    @Override
    public List<Item> getAll() {

        return dao.getAllItems();
    }

    @Override
    public boolean updateItemDesc(String Desc, String itemId) {
        ItemDesc desc = new ItemDesc();
        desc.setDesc(Desc);
        desc.setItemId(itemId);
        return Ddao.updateEntity(desc);

    }

    @Override
    public boolean updateItemImage(String newImagePath, String itemId) {
        ItemDesc desc = new ItemDesc();
        desc.setImagePath(newImagePath);
        desc.setItemId(itemId);
        return Ddao.updateEntity(desc);
    }

    @Override
    public Item findbyitemid(String item_id) {
        Item item = new Item();
        item.setId(item_id);
        return dao.findByEntity(item);
    }

    public String getItemPriceById(String item_id) {
        Item item = new Item();
        item.setId(item_id);
        return dao.findByEntity(item).getPrice().toString();
    }

    public boolean updateItem(Item item) {
        return dao.updateEntity(item);
    }

    public List<Item> getMyItems(String userId, Map<String, Object> whereMap, int page, int limit) {
        return dao.getMyItems(userId, whereMap, page, limit);
    }

    public List<Item> getMyItems(String userId, int page, int limit) {
        return dao.getMyItems(userId, page, limit);
    }

    public List<Item> getAll(Map<String, Object> whereMap, int page, int limit) {
        return dao.getAllItems(whereMap, page, limit);
    }

    public List<Item> getAll(int page, int limit) {
        return dao.getAllItems(page, limit);
    }
}
