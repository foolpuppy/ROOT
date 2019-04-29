package top.wigon.service.impl;

import top.wigon.DAO.impl.ItemDAOImpl;
import top.wigon.DAO.impl.ItemDescImpl;
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
    public List<Item> findItemsByName(Item item) {
        Map<String, Object> keyword = dao.getConditionValMap(item);
        return dao.findByCondition(keyword);
    }

    @Override
    public List<Item> findItemsByCategoryCols(String category, int cols) {
        Map<String, Object> keyword = new HashMap<>();
        keyword.put("item_category", category);
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
    public List<Item> getAll() {

        return dao.getAllItems();
    }

    @Override
    public boolean updateItemDesc(String Desc, String id) {
        ItemDesc desc = new ItemDesc();
        desc.setDesc(Desc);
        return Ddao.updateEntity(desc);

    }

    @Override
    public boolean updateItemImage(String newImagePath, String id) {
        ItemDesc desc = new ItemDesc();
        desc.setImagePath(newImagePath);
        return Ddao.updateEntity(desc);
    }

}
