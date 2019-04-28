package top.wigon.DAO.impl;

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
}
