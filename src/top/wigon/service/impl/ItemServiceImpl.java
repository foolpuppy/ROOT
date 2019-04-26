package top.wigon.service.impl;

import top.wigon.DAO.impl.ItemDAOImpl;
import top.wigon.entity.Item;
import top.wigon.service.ItemService;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/26 9:57
 **/
public class ItemServiceImpl implements ItemService {
    private ItemDAOImpl dao=new ItemDAOImpl();
    @Override
    public Boolean itemAdd(Item item) {
        return dao.addEntity(item);
    }

    @Override
    public Item[] findItemsByName(String keyword) {
        return new Item[0];
    }
}
