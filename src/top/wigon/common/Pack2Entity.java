package top.wigon.common;

import top.wigon.entity.Item;
import top.wigon.entity.Order;
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
            user.setUserId(result.get(i).get("user_id").toString());
            user.setUserName(result.get(i).get("username").toString());
            user.setPassword(result.get(i).get("password").toString());
            user.setTel(result.get(i).get("tel").toString());
            user.setEmail(result.get(i).get("email").toString());
            user.setAvatarPath(String.valueOf(result.get(i).get("avatar_path")));
            user.setRoleType(String.valueOf(result.get(i).get("role_type")));
            user.setCreateTime(result.get(i).get("gmt_create").toString());
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
            item.setId(result.get(i).get("item_id").toString());
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

    public static List<Order> pack2orders(List<Map<String, Object>> result) {
        List<Order> list = new ArrayList<>();
        Order order;

        for (int i = 0; i < result.size(); i++) {
            order = new Order();
            order.setOrderId(result.get(i).get("order_id").toString());
            order.setUserId(result.get(i).get("user_id").toString());
            order.setPayment(new BigDecimal(String.valueOf(result.get(i).get("payment") == null ? 0 : result.get(i).get("payment"))));
            order.setPaymentType(Integer.parseInt(result.get(i).get("payment_type").toString()));
            order.setPostFee(new BigDecimal(String.valueOf(result.get(i).get("post_fee") == null ? 0 : result.get(i).get("post_fee"))));
            order.setOrderState(Integer.parseInt(result.get(i).get("order_state").toString()));
            order.setOrderCreateTime(String.valueOf(result.get(i).get("create_time")));
            order.setPaymentTime(String.valueOf(result.get(i).get("payment_time")));
            order.setConsignTime(String.valueOf(result.get(i).get("consign_time")));
            order.setReceiveTime(String.valueOf(result.get(i).get("receive_time")));
            order.setEndTime(String.valueOf(result.get(i).get("end_time")));
            order.setCloseTime(String.valueOf(result.get(i).get("close_time")));
            order.setCloseTime(String.valueOf(result.get(i).get("shipping_name")));
            order.setShipingCode(String.valueOf(result.get(i).get("shipping_code")));
            list.add(order);
        }
        return list;
    }

}
