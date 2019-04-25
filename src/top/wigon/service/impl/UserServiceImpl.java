package top.wigon.service.impl;

import com.sun.org.apache.xpath.internal.operations.Bool;
import top.wigon.DAO.BaseDAO;
import top.wigon.DAO.UserDao;
import top.wigon.DAO.impl.UserDaoIpml;
import top.wigon.entity.User;
import top.wigon.service.UserService;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/25 9:46
 **/
public class UserServiceImpl implements UserService {
    @Override
    public Boolean userLogin(User user) {
        UserDaoIpml dao = new UserDaoIpml();
        return user.getPassword().equals(dao.findByEntity(user).getPassword());
    }
}
