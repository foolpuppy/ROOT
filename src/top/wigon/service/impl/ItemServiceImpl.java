package top.wigon.service.impl;

import top.wigon.DAO.impl.ItemDAOImpl;
import top.wigon.entity.Item;
import top.wigon.service.ItemService;

import java.util.List;
import java.util.Map;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/26 9:57
 **/
public class ItemServiceImpl implements ItemService {
    private ItemDAOImpl dao = new ItemDAOImpl();

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
    public List<Item> getAll() {

        return dao.getAllItems();
    }

}
