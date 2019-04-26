package top.wigon.common;

import top.wigon.entity.Item;
import top.wigon.entity.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/25 10:51
 **/
public class Pack2Entity {
    /**
     * 结果集转为User实体实体
     *
     * @param result
     * @return
     */
    public static List<User> pack2users(List<Map<String, Object>> result) {
        List<User> list = new ArrayList<>();
        User user;
        for (int i = 0; i < result.size(); i++) {
            user = new User();
            user.setUserId(result.get(0).get("user_id").toString());
            user.setUserName(result.get(0).get("username").toString());
            user.setPassword(result.get(0).get("password").toString());
            user.setTel(result.get(0).get("tel").toString());
            user.setEmail(result.get(0).get("email").toString());
            user.setAvatarPath(String.valueOf(result.get(0).get("avatar_path")));
            user.setCreateTime(result.get(0).get("gmt_create").toString());
            list.add(user);
        }
        return list;
    }

    /**
     * 返回Item实体集合
     *
     * @param result
     * @return
     */
    public static List<Item> pack2items(List<Map<String, Object>> result) {
        List<Item> list = new ArrayList<>();
        Item item;

        for (int i = 0; i < result.size(); i++) {
            item = new Item();
            item.setId(result.get(1).get("item_id").toString());
            item.setCategory(result.get(i).get("item_category").toString());
            item.setTitle(result.get(i).get("item_title").toString());
            item.setPrice(new BigDecimal(String.valueOf(result.get(i).get("price") == null ? 0 : result.get(i).get("price"))));
            item.setStock(Integer.parseInt(result.get(i).get("item_stock").toString()));
            item.setState(Integer.parseInt(result.get(i).get("item_state").toString()));
            item.setShopId(Integer.parseInt(result.get(i).get("shop_id").toString()));
            list.add(item);

        }
        return list;
    }

}
