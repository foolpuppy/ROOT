package top.wigon.service.impl;

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
    public Boolean userLoginByphone(User user) {
        UserDaoIpml dao = new UserDaoIpml();
        //比对Tel
        if (dao.findByEntity(user).getTel() != null) {
            return user.getPassword().equals(dao.findByEntity(user).getPassword());
        }
        return false;
    }
}
