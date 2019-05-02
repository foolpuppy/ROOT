package top.wigon.DAO.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import top.wigon.DAO.UserDAO;
import top.wigon.common.DBUtils;
import top.wigon.common.Pack2Entity;
import top.wigon.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/25 9:45
 **/
public class UserDAOIpml implements UserDAO {
    private final String tableName = "tb_user";
    private final String QUERY_ORDER_INFO = "SELECT tb_order.order_id,tb_order.user_id,tb_order.payment,tb_order.payment_type,tb_order.post_fee,tb_order.order_state,tb_order.create_time,tb_order.update_time,tb_order.payment_time,tb_order.consign_time,tb_order.receive_time,tb_order.end_time,tb_order.close_time,tb_order.shipping_name,tb_order.shipping_code,tb_order.gmt_create,tb_order.gmt_modified,tb_order_item.item_num,tb_item.item_category,tb_order_item.item_title,tb_order_item.item_price,tb_order_item.total_fee,tb_order_item.item_id,tb_desc.item_image_path FROM tb_order LEFT JOIN tb_order_item ON tb_order.order_id = tb_order_item.order_id JOIN tb_desc on tb_order_item.item_id=tb_desc.item_id join tb_item on  tb_order_item.item_id=tb_item.item_id WHERE tb_order.order_id = (SELECT order_id from tb_order where user_id=(select user_id from tb_user where tel=?))";
    /**
     * 特殊处理 用手机号唯一标识用户
     *
     * @param user
     * @return
     */
    @Override
    public User findByEntity(User user) {
        Map<String, Object> wheremap = new HashMap<>();
        //通过手机号查询用户
        wheremap.put("tel", user.getTel());
        List<Map<String, Object>> result = null;
        try {
            result = DBUtils.query(tableName, wheremap);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result != null && result.size() > 0) {
            //单用户查找返回一个
            return Pack2Entity.pack2users(result).get(0);
        } else {
            return new User();
        }

    }

    @Override
    public Boolean addEntity(User user) {
        Map<String, Object> valueMap = new HashMap<>();
        valueMap.put("username", user.getUserName());
        valueMap.put("password", user.getPassword());
        valueMap.put("tel", user.getTel());
        valueMap.put("email", user.getEmail());
        boolean flag = false;
        try {
            flag = DBUtils.insert(tableName, valueMap) > 0;
        } catch (SQLException e) {
//            e.printStackTrace();
            System.err.println("用户添加失败");
        }
        return flag;

    }

    @Override
    public boolean updateEntity(User user) {
        boolean flag = false;
        try {
            flag = DBUtils.update(tableName, getValMap(user), getPrimaryKey(user)) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteEntity(User user) {
        boolean flag = false;
        try {
            flag = DBUtils.delete(tableName, getPrimaryKey(user)) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Map<String, Object> getValMap(User user) {
        Map<String, Object> valueMap = new HashMap<>();
        valueMap.put("user_id", user.getUserId());
        valueMap.put("username", user.getUserName());
        valueMap.put("password", user.getPassword());
        valueMap.put("tel", user.getTel());
        valueMap.put("email", user.getEmail());
        valueMap.put("avatar_path", user.getAvatarPath());
        valueMap.put("role_type", user.getRoleType());
        return valueMap;
    }

    /**
     * @param user
     * @return
     */
    @Override
    public Map<String, Object> getPrimaryKey(User user) {
        Map<String, Object> pk = new HashMap<>();
        pk.put("user_id", user.getUserId());
        return pk;
    }

    /**
     * 获取所有用户集合
     *
     * @return
     */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            List<Map<String, Object>> result = DBUtils.query(tableName, null);
            users = Pack2Entity.pack2users(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public String getUserOrderByTel(String tel) throws SQLException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        return objectMapper.writeValueAsString((DBUtils.executeQuery(QUERY_ORDER_INFO, new Object[]{tel})));

    }
}
