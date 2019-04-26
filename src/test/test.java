package test;

import top.wigon.common.DBUtils;

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
        val.put("item_id", "6");
        val.put("item_title", "三");
        DBUtils.queryLike("tb_item", val);


    }
}
