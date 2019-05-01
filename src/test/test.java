package test;

import top.wigon.entity.Item;
import top.wigon.service.impl.ItemServiceImpl;

import java.util.HashMap;
import java.util.List;
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

//        Order order = new Order();
//        order.setOrderId(DBUtils.getCurrentTimeMillis());
//        order.setOrderCreateTime(DBUtils.getCurrDateTime());
//        order.setUserId("88888888");
//        order.setCreateTime(DBUtils.getCurrDateTime());
//        OrderServiceImpl orderService = new OrderServiceImpl();
//        boolean flag = orderService.createOrder(order);
//        OrderItem orderItem = new OrderItem();
//        orderItem.setItemId(888888888);
//        orderItem.setNum(3);
//        orderItem.setPrice(BigDecimal.valueOf(1111));
//        orderItem.setTitle("测试商品三");
//        orderItem.setOrderId(order.getOrderId());
//        OrderItemServiceImpl orderItemService = new OrderItemServiceImpl();
//        orderItemService.add(orderItem);
        ItemServiceImpl itemService = new ItemServiceImpl();
        List<Item> items_0f = itemService.findItemsByPrice(100, 0, 4);
        List<Item> items_1f = itemService.findItemsByCategoryCols("笔记本电脑", 5);
        List<Item> items_2f = itemService.findItemsByCategoryCols("水果生鲜", 5);
        List<Item> items_3f = itemService.findItemsByCategoryCols("美妆馆", 5);
        List<Item> items_all = itemService.getAll();
    }
}
