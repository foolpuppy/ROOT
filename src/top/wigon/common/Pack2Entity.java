package top.wigon.common;

import top.wigon.entity.Item;
import top.wigon.entity.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/25 10:51
 **/
public class Pack2Entity {
    /**
     * 结果集转为User实体
     *
     * @param result
     * @return
     */
    public static User pack2user(List<Map<String, Object>> result) {
        User user = new User();
        if (result.size() > 0) {
            /*
            如果表列名对应实体属性可以使用：*/
            for (Map<String, Object> list : result) {
                list.forEach((k, v) -> System.out.println(k + " " + v));
            }
            /**/
            user.setUserId(result.get(0).get("user_id").toString());
            user.setUserName(result.get(0).get("username").toString());
            user.setPassword(result.get(0).get("password").toString());
            user.setTel(result.get(0).get("tel").toString());
            user.setEmail(result.get(0).get("email").toString());
            user.setAvatarPath(String.valueOf(result.get(0).get("avatar_path")));
            user.setCreateTime(result.get(0).get("gmt_create").toString());
        }
        return user;
    }

    public static Item pack2item(List<Map<String, Object>> result) {
        Item item = new Item();
        item.setId(result.get(0).get("item_id").toString());
        item.setCategory(result.get(0).get("item_category").toString());
        item.setTitle(result.get(0).get("item_title").toString());
        item.setPrice(new BigDecimal(result.get(0).get("price").toString()));
        item.setStock(Integer.parseInt(result.get(0).get("item_stock").toString()));
        item.setState(Integer.parseInt(result.get(0).get("item_state").toString()));
        item.setShopId(Integer.parseInt(result.get(0).get("shop_id").toString()));
        item.setCreateTime(result.get(0).get("gmt_create").toString());
        return item;
    }
}
