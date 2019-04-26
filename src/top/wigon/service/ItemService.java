package top.wigon.service;

import top.wigon.entity.Item;

import java.util.List;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/26 9:54
 **/
public interface ItemService {
    /**
     * 添加商品
     *
     * @param item
     * @return
     */
    Boolean itemAdd(Item item);

    /**
     * 关键字商品标题模糊查询
     *
     * @param item
     * @return
     */
    List<Item> findItemsByName(Item item);

    /**
     * 获得所有商品
     * @return
     */
    List<Item> getAll();
}
