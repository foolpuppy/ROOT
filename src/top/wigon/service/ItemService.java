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
     * 通过商品ID删除
     *
     * @param itemId
     * @return
     */
    Boolean itemDel(String itemId);

    /**
     * 关键字商品标题模糊查询
     *
     * @param item
     * @return
     */
    List<Item> findItemsByName(Item item);

    /**
     * 类别查询  显示行数
     *
     * @param category
     * @param clos
     * @return
     */
    List<Item> findItemsByCategoryCols(String category, int clos);

    /**
     * 类别查询
     *
     * @param category
     * @return
     */
    List<Item> findItemsByCategory(String category);

    /**
     * 价格筛选商品
     *
     * @param hPrice
     * @param lPrice
     * @return
     */
    List<Item> findItemsByPrice(int hPrice, int lPrice, int cols);

    /**
     * 获得所有商品
     *
     * @return
     */
    List<Item> getAll();

    /**
     * 更新商品描述信息
     *
     * @param Desc
     * @param id
     * @return
     */
    boolean updateItemDesc(String Desc, String id);

    /**
     * 更新商品图片地址
     *
     * @param Desc
     * @param id
     * @return
     */
    boolean updateItemImage(String Desc, String id);

    /**
     * 根据Item_Id 查询
     *
     * @param item_id
     * @return
     */
    Item findbyitemid(String item_id);

}
