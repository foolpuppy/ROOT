package test;

import top.wigon.entity.OrderItem;
import top.wigon.service.impl.OrderItemServiceImpl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/24 18:56
 **/
public class test {
    public static void main(String[] args) throws Exception {
        Map<String, Object> val = new HashMap<>();
//        val.put("now", DBUtils.getCurrDateTime());
//        System.out.println(new java.sql.Timestamp(new java.util.Date().getTime()));
//        System.out.println(DBUtils.getCurrDateTime());
//        DBUtils.insert("test", val);
//        val.put("item_id", "6");
//        val.put("item_title", "三");
//        DBUtils.queryLike("tb_item", val);
//        DBUtils.query("tb_shop", null);
//        List<Item> items = new ArrayList<>();
//        List<Map<String, Object>> result = DBUtils.query("tb_item", null);
//        items = Pack2Entity.pack2items(result);
//        for (Item item : items) {
//            System.out.println(item.getTitle());
//        }
//        System.out.println(System.currentTimeMillis());
        OrderItem orderItem = new OrderItem();
        orderItem.setItemId(1111111111);
        orderItem.setNum(3);
        orderItem.setPrice(BigDecimal.valueOf(1111));
        orderItem.setTitle("测试商品三");
        OrderItemServiceImpl orderItemService = new OrderItemServiceImpl();
        orderItemService.add(orderItem);
    }
}
