package top.wigon.DAO.impl;

import top.wigon.DAO.UserDao;
import top.wigon.common.DBUtils;
import top.wigon.common.Pack2Entity;
import top.wigon.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/25 9:45
 **/
public class UserDaoIpml implements UserDao {
    @Override
    public User findByEntity(User user) {
        Map<String, Object> wheremap = new HashMap<>();
        //通过手机号查询用户
        wheremap.put("tel", user.getTel());
        List<Map<String, Object>> result = null;
        try {
            result = DBUtils.query("tb_user", wheremap);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result != null) {
            return Pack2Entity.pack2user(result);
        } else {
            return new User();
        }

    }

    @Override
    public Boolean insertEntity(User user) {
        return null;
    }
}
