package top.wigon.common;

import top.wigon.entity.Package;
import top.wigon.entity.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/25 10:51
 * 结果集转换为实体类
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
            user.setPassword(result.get(i).get("password") == null ? "" : result.get(i).get("password").toString());
            user.setTel(String.valueOf(result.get(i).get("tel").toString()));
            user.setEmail(String.valueOf(result.get(i).get("email")));
            user.setAvatarPath(result.get(i).get("avatar_path") == null ? "res/avatar/default.png" : result.get(i).get("avatar_path").toString());
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
            item.setPrice(new BigDecimal(String.valueOf(result.get(i).get("item_price") == null ? 0 : result.get(i).get("item_price"))));
            item.setStock(Integer.parseInt(result.get(i).get("item_stock").toString()));
            item.setState(Integer.parseInt(result.get(i).get("item_state").toString()));
            item.setShopId(Integer.parseInt(result.get(i).get("shop_id").toString()));
            item.setItem_image_path(String.valueOf(result.get(i).get("item_image_path")));
            if (result.get(i).get("gmt_create") != null) {
                item.setCreateTime(result.get(i).get("gmt_create").toString());
            }
            item.setDesc(result.get(i).get("item_desc") == null ? "空" : result.get(i).get("item_desc").toString());
            item.setModified_time(String.valueOf(result.get(i).get("gmt_modified") == null ? "" : result.get(i).get("gmt_modified")));
            list.add(item);

        }
        return list;
    }

    /**
     * 返回订单实体
     *
     * @param result
     * @return
     */
    public static List<Order> pack2orders(List<Map<String, Object>> result) {
        List<Order> list = new ArrayList<>();
        Order order;

        for (int i = 0; i < result.size(); i++) {
            order = new Order();
            order.setOrderId(result.get(i).get("order_id").toString());
            order.setUserId(result.get(i).get("user_id").toString());
            order.setPayment(new BigDecimal(String.valueOf(result.get(i).get("payment") == null ? 0 : result.get(i).get("payment"))));
            order.setPaymentType(Integer.parseInt(result.get(i).get("payment_type") == null ? "0" : result.get(i).get("payment_type").toString()));
            order.setPostFee(new BigDecimal(String.valueOf(result.get(i).get("post_fee") == null ? 0 : result.get(i).get("post_fee"))));
            order.setOrderState(Integer.parseInt(result.get(i).get("order_state") == null ? "-1" : result.get(i).get("order_state").toString()));
            order.setOrderCreateTime(String.valueOf(result.get(i).get("create_time")));
            order.setPaymentTime(String.valueOf(result.get(i).get("payment_time")));
            order.setConsignTime(String.valueOf(result.get(i).get("consign_time")));
            order.setReceiveTime(String.valueOf(result.get(i).get("receive_time")));
            order.setEndTime(String.valueOf(result.get(i).get("end_time")));
            order.setCloseTime(String.valueOf(result.get(i).get("close_time")));
            order.setShippingName(String.valueOf(result.get(i).get("shipping_name")));
            order.setshippingCode(String.valueOf(result.get(i).get("shipping_code")));
            list.add(order);
        }
        return list;
    }

    /**
     * 结果集转为ItemDesc实体实体
     *
     * @param result
     * @return
     */
    public static List<ItemDesc> pack2ItemDesc(List<Map<String, Object>> result) {
        List<ItemDesc> list = new ArrayList<>();
        ItemDesc itemDesc;
        for (int i = 0; i < result.size(); i++) {
            itemDesc = new ItemDesc();
            itemDesc.setItemId(result.get(i).get("item_id").toString());
            itemDesc.setId(Integer.parseInt(result.get(i).get("id").toString()));
            itemDesc.setImagePath(String.valueOf(result.get(i).get("item_image_path")));
            itemDesc.setDesc(String.valueOf(result.get(i).get("item_desc")));
            itemDesc.setCreateTime(result.get(i).get("gmt_create").toString());
            list.add(itemDesc);
        }
        return list;
    }

    /**
     * 转换为物流信息
     *
     * @param result
     * @return
     */
    public static List<Shipping> pack2Shippins(List<Map<String, Object>> result) {
        List<Shipping> list = new ArrayList<>();
        Shipping shipping;
        for (int i = 0; i < result.size(); i++) {
            shipping = new Shipping();
            shipping.setOrderId(result.get(i).get("order_id").toString());
            shipping.setReceiverName(result.get(i).get("receiver_name").toString());
            shipping.setReceiverTel(result.get(i).get("receiver_tel").toString());
            shipping.setReceiverState(result.get(i).get("receiver_state").toString());
            shipping.setReceiverCity(result.get(i).get("receiver_city").toString());
            shipping.setReceiverDistrict(result.get(i).get("receiver_district").toString());
            shipping.setReceiverZip(result.get(i).get("receiver_zip").toString());
            shipping.setReceiverAddress(result.get(i).get("receiver_address").toString());
            shipping.setCurrLoc(result.get(i).get("current_location").toString());
            shipping.setCreateTime(result.get(i).get("gmt_create").toString());
            list.add(shipping);
        }
        return list;
    }

    /**
     * 包装为包裹信息
     *
     * @param result
     * @return
     */
    public static List<Package> pack2Packages(List<Map<String, Object>> result) {
        List<Package> list = new ArrayList<>();
        Package packageInfo;
        for (int i = 0; i < result.size(); i++) {
            packageInfo = new Package();
            packageInfo.setOrderid(result.get(i).get("order_id").toString());
            packageInfo.setCurrLoc(result.get(i).get("current_location").toString());
            packageInfo.setImgPath(result.get(i).get("item_image_path").toString());
            packageInfo.setItemCategory(result.get(i).get("item_category").toString());
            packageInfo.setItemId(result.get(i).get("item_id").toString());
            packageInfo.setItemNums(Integer.parseInt(result.get(i).get("item_num").toString()));
            packageInfo.setOrderState(result.get(i).get("order_state").toString());
            packageInfo.setItemTitle(result.get(i).get("item_title").toString());
            packageInfo.setCurrLoc(result.get(i).get("current_location").toString());
            packageInfo.setPayment(result.get(i).get("payment").toString());
            list.add(packageInfo);
        }
        return list;
    }

}
