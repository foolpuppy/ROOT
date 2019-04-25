package top.wigon.service.impl;

import top.wigon.DAO.impl.UserDaoIpml;
import top.wigon.common.DBUtils;
import top.wigon.entity.User;
import top.wigon.service.UserService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/25 9:46
 **/
public class UserServiceImpl implements UserService {
    @Override
    public Boolean userLoginByphone(User user) {
        UserDaoIpml dao = new UserDaoIpml();
        //比对Tel
        if (dao.findByEntity(user).getTel() != null) {
            return user.getPassword().equals(dao.findByEntity(user).getPassword());
        }
        return false;
    }

    @Override
    public Boolean userAdd(User user) {
        Map<String, Object> valueMap = new HashMap<>();
        valueMap.put("username", user.getUserName());
        valueMap.put("password", user.getPassword());
        valueMap.put("tel", user.getTel());
        valueMap.put("email", user.getEmail());
        valueMap.forEach((k, v) -> System.out.println("k: " + k + ",v: " + v)
        );
        boolean flag = false;
        try {
            flag = DBUtils.insert("tb_user", valueMap) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("用户添加失败");
        }
        return flag;
    }
}
