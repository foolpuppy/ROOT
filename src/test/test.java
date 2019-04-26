package test;

import top.wigon.common.DBUtils;
import top.wigon.common.Pack2Entity;
import top.wigon.entity.Item;

import java.util.ArrayList;
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
        DBUtils.query("tb_shop", null);
        List<Item> items = new ArrayList<>();
        List<Map<String, Object>> result = DBUtils.query("tb_item", null);
        items = Pack2Entity.pack2items(result);
        for (Item item : items) {
            System.out.println(item.getTitle());
        }

    }
}
