package test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import top.wigon.DAO.impl.OrderDAOImpl;
import top.wigon.entity.Order;

import java.util.List;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/24 22:47
 **/
public class JSONTest {
    public static void main(String[] args) throws Exception {
        OrderDAOImpl userService = new OrderDAOImpl();
        List<Order> userList = userService.getAllOrders();
        ObjectMapper objectMapper = new ObjectMapper();
        String JSON = objectMapper.writeValueAsString(userList);
        System.out.println(JSON);
        //设置序列化后的格式，INDENT_OUTPUT表示缩进输出，true表示试该配置生效
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        String JSON2 = objectMapper.writeValueAsString(userList);
        System.out.println(JSON2);
        //反序列化数组对象
        List<Order> UserList = objectMapper.readValue(JSON2, new TypeReference<List<Order>>() {
        });
        UserList.forEach(System.out::println);
//        Map<String, Object> map = new HashMap<>();
//        //映射为Map 对象 再 遍历
//        map = objectMapper.readValue(JSON2, map.getClass());
//        map.forEach((k, v) -> System.out.println(" key: " + k + " value: " + v));
    }
}
