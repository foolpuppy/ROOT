package top.wigon.dao.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import top.wigon.common.DBUtils;
import top.wigon.common.Pack2Entity;
import top.wigon.dao.UserDAO;
import top.wigon.entity.User;

import java.sql.SQLException;
import java.util.*;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/25 9:45
 **/
public class UserDAOImpl implements UserDAO {
    private static final String GET_SHOP_ID_BY_USERID = "SELECT shop_id from tb_shop where user_id=?";
    private final String tableName = "tb_user";
    /* private final String QUERY_ORDER_INFO_UNPAID = "SELECT DISTINCT(tb_order.order_id),tb_order.user_id,tb_order.payment,tb_order.payment_type,tb_order.post_fee,tb_order.order_state,tb_order.create_time,tb_order.update_time,tb_order.payment_time,tb_order.consign_time,tb_order.receive_time,tb_order.end_time,tb_order.close_time,tb_order.shipping_name,tb_order.shipping_code,tb_order.gmt_create,tb_order.gmt_modified,sum(tb_order_item.item_num) item_num,tb_item.item_category,tb_order_item.item_title,tb_order_item.item_price,tb_order_item.total_fee,tb_order_item.item_id,tb_desc.item_image_path FROM tb_order LEFT JOIN tb_order_item ON tb_order.order_id = tb_order_item.order_id JOIN tb_desc on tb_order_item.item_id=tb_desc.item_id join tb_item on  tb_order_item.item_id=tb_item.item_id WHERE tb_order.order_id in (SELECT order_id from tb_order where user_id = (select user_id from tb_user where tel=?)) and tb_order.order_state=1\n" +
             "GROUP BY order_id";*/
    private final String QUERY_ORDER_INFO_UNPAID = "SELECT tb_order.order_id,tb_order.user_id,tb_order.payment,tb_order.payment_type,tb_order.post_fee,tb_order.order_state,tb_order.create_time,tb_order.update_time,tb_order.payment_time,tb_order.consign_time,tb_order.receive_time,tb_order.end_time,tb_order.close_time,tb_order.shipping_name,tb_order.shipping_code,tb_order.gmt_create,tb_order.gmt_modified,tb_order_item.item_num ,tb_item.item_category,tb_order_item.item_title,tb_order_item.item_price,tb_order_item.total_fee,tb_order_item.item_id,tb_desc.item_image_path FROM tb_order LEFT JOIN tb_order_item ON tb_order.order_id = tb_order_item.order_id JOIN tb_desc ON tb_order_item.item_id = tb_desc.item_id JOIN tb_item ON tb_order_item.item_id = tb_item.item_id WHERE tb_order.order_id IN ( SELECT order_id FROM tb_order WHERE user_id = ( SELECT user_id FROM tb_user WHERE tel = ? ) )AND tb_order.order_state =1";
    //    private final String QUERY_ALL_ORDER_INFO = "SELECT DISTINCT(tb_order.order_id),tb_order.user_id,tb_order.payment,tb_order.payment_type,tb_order.post_fee,tb_order.order_state,tb_order.create_time,tb_order.update_time,tb_order.payment_time,tb_order.consign_time,tb_order.receive_time,tb_order.end_time,tb_order.close_time,tb_order.shipping_name,tb_order.shipping_code,tb_order.gmt_create,tb_order.gmt_modified,sum(tb_order_item.item_num) item_num,tb_item.item_category,tb_order_item.item_title,tb_order_item.item_price,tb_order_item.total_fee,tb_order_item.item_id,tb_desc.item_image_path FROM tb_order LEFT JOIN tb_order_item ON tb_order.order_id = tb_order_item.order_id JOIN tb_desc on tb_order_item.item_id=tb_desc.item_id join tb_item on  tb_order_item.item_id=tb_item.item_id WHERE tb_order.order_id in (SELECT order_id from tb_order where user_id = (select user_id from tb_user where tel=?))GROUP BY order_id";
    private final String QUERY_ALL_ORDER_INFO = "SELECT tb_order.order_id,tb_order.user_id,tb_order.payment,tb_order.payment_type,tb_order.post_fee,tb_order.order_state,tb_order.create_time,tb_order.update_time,tb_order.payment_time,tb_order.consign_time,tb_order.receive_time,tb_order.end_time,tb_order.close_time,tb_order.shipping_name,tb_order.shipping_code,tb_order.gmt_create,tb_order.gmt_modified,tb_order_item.item_num,tb_item.item_category,tb_order_item.item_title,tb_order_item.item_price,tb_order_item.total_fee,tb_order_item.item_id,tb_desc.item_image_path FROM tb_order LEFT JOIN tb_order_item ON tb_order.order_id = tb_order_item.order_id JOIN tb_desc on tb_order_item.item_id=tb_desc.item_id join tb_item on  tb_order_item.item_id=tb_item.item_id WHERE tb_order.order_id in (SELECT order_id from tb_order where user_id = (select user_id from tb_user where tel=?))";
    private final String QUERY_USER_UNPAID_NUMS = "SELECT COUNT(1) num FROM tb_order WHERE user_id=? AND order_state=1 ";
    private final String CHANGE_ROLETYPE = "UPDATE tb_user SET role_type =? WHERE user_id=?";
    private final String QUERY_USER_BY_ROLE_LIKE = "SELECT tb_user.user_id,tb_user.avatar_path,tb_user.username,tb_user.tel,tb_user.email,tb_user.role_type,tb_user.gmt_create FROM tb_user WHERE role_type IN   ";
    private final String GET_USER_ROLE_TYPE = "SELECT role_type FROM tb_user WHERE user_id=?";

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
        if (user.getPassword() != null) {
            valueMap.put("password", user.getPassword());
        }
        valueMap.put("tel", user.getTel());
        valueMap.put("email", user.getEmail());
        if (user.getAvatarPath() != null) {
            valueMap.put("avatar_path", user.getAvatarPath());
        }
        if (user.getRoleType() != null) {
            valueMap.put("role_type", user.getRoleType());
        }
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
        return objectMapper.writeValueAsString((DBUtils.executeQuery(QUERY_ALL_ORDER_INFO, new Object[]{tel})));

    }

    public String getUserOrderUnPaidByTel(String tel) throws SQLException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        return objectMapper.writeValueAsString((DBUtils.executeQuery(QUERY_ORDER_INFO_UNPAID, new Object[]{tel})));
    }

    public int getUserOrderUnPaidNumByUserId(String userid) throws SQLException, JsonProcessingException {
        int res = 0;
        res = Integer.parseInt(String.valueOf(DBUtils.executeQuery(QUERY_USER_UNPAID_NUMS, new Object[]{userid}).get(0).get("num")));
        return res;
    }

    public boolean changeRoleTypeById(String userId, String roleType) {
        boolean flag = false;
        try {
            flag = DBUtils.executeUpdate(CHANGE_ROLETYPE, new Object[]{roleType, userId}) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public List<User> getUserByRole(String role, Map<String, Object> whereMap, int page, int limit) {
        List<User> users = new ArrayList<>();
        try {
            if (role.equals("1")) {
                role = "2";
            } else {
                role = "0,1";
            }
            StringBuilder SQL = new StringBuilder();
            SQL.append(QUERY_USER_BY_ROLE_LIKE);
            SQL.append("(" + role + ")");
            if (whereMap != null && whereMap.size() > 0) {
                Iterator<String> iterator = whereMap.keySet().iterator();
                //i=1就 会从第一个WherMap 开始 添加条件
                int i = 1;
                while (iterator.hasNext()) {
                    String key = iterator.next();
                    SQL.append(i == 0 ? " where " : " ");
                    SQL.append(i == 0 || i == 1 ? " and ( " : " OR ");
                    SQL.append(key + " like '%" + whereMap.get(key) + "%'");
                    i++;
                }
                SQL.append(") LIMIT " + (page == -1 ? limit : (page - 1) * limit + " , " + limit));
                List<Map<String, Object>> result = DBUtils.executeQuery(SQL.toString(), null);
                users = Pack2Entity.pack2users(result);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public List<User> getUserByRole(String role, int page, int limit) {
        List<User> users = new ArrayList<>();
        try {
            if (role.equals("1")) {
                role = "2";
            } else {
                role = "0,1";
            }

            List<Map<String, Object>> result = DBUtils.executeQuery(QUERY_USER_BY_ROLE_LIKE + "(" + role + ") Limit " + (page == -1 ? 100 : (page - 1) * limit + " , " + limit), null);
            users = Pack2Entity.pack2users(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public int getUserRoleType(String userId) {
        int roleType = 0;
        try {
            roleType = Integer.parseInt(String.valueOf(DBUtils.executeQuery(GET_USER_ROLE_TYPE, new Object[]{userId}).get(0).get("role_type")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roleType;
    }

    public String getShopIdByUserId(String userId) {
        String shopId = null;
        try {
            shopId = String.valueOf(DBUtils.executeQuery(GET_SHOP_ID_BY_USERID, new Object[]{userId}).get(0).get("shop_id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shopId;
    }
}
