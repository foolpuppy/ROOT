package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import top.wigon.common.DBUtils;
import top.wigon.entity.Item;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/24 22:47
 **/
public class JSONTest {
    public static void main(String[] args) throws IOException {
        Item item = new Item("0000001", "小米10", "电子产品", new BigDecimal(9999), 100, 1, 100001, DBUtils.getCurrDateTime());
        ObjectMapper objectMapper = new ObjectMapper();
        String JSON = objectMapper.writeValueAsString(item);
        System.out.println(JSON);
        //设置序列化后的格式，INDENT_OUTPUT表示缩进输出，true表示试该配置生效
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        String JSON2 = objectMapper.writeValueAsString(item);
        System.out.println(JSON2);
        Item Xitem = objectMapper.readValue(JSON, Item.class);
        System.out.println(Xitem);
        Map<String, Object> map = new HashMap<>();
        //映射为Map 对象 再 遍历
        map = objectMapper.readValue(JSON2, map.getClass());
        map.forEach((k, v) -> System.out.println(" key: " + k + " value: " + v));
    }
}
