package top.wigon.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import top.wigon.dao.impl.UserDAOImpl;
import top.wigon.entity.User;
import top.wigon.service.UserService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/25 9:46
 **/
public class UserServiceImpl implements UserService {
    private UserDAOImpl dao = new UserDAOImpl();

    @Override
    public Boolean userLoginByphone(User user) {
        //比对Tel
        if (dao.findByEntity(user).getTel() != null) {
            return user.getPassword().equals(dao.findByEntity(user).getPassword());
        }
        return false;
    }

    @Override
    public Boolean userAdd(User user) {
        return dao.addEntity(user);
    }

    /**
     * 修改用户名 邮箱和  密码
     *
     * @param user
     * @return
     */
    @Override
    public Boolean userEdit(User user) {
        return dao.updateEntity(user);
    }

    /**
     * 删除用户通过Uid
     *
     * @param userId
     * @return
     */
    @Override
    public Boolean userDel(String userId) {
        User user = new User();
        user.setUserId(userId);
        return dao.deleteEntity(user);
    }

    @Override
    public Boolean checkTelExist(String tel) {
        User user = new User();
        user.setTel(tel);
        return dao.findByEntity(user).getTel() != null;
    }

    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Override
    public String getUserIDByTel(String tel) {
        User user = new User();
        user.setTel(tel);
        return dao.findByEntity(user).getUserId();
    }

    @Override
    public String getUserOrderInfoByTel(String tel) {
        String result = "";
        try {
            result = dao.getUserOrderByTel(tel);
        } catch (SQLException | JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String getUserOrderUnPaidInfoByTel(String tel) {
        String result = "";
        try {
            result = dao.getUserOrderUnPaidByTel(tel);
        } catch (SQLException | JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public User getUserByTel(String tel) {
        User user = new User();
        user.setTel(tel);
        return dao.findByEntity(user);

    }

    public int getUserOrderUnPaidNumByUserId(String userId) throws SQLException, JsonProcessingException {
        return dao.getUserOrderUnPaidNumByUserId(userId);

    }

    public boolean setUserRoleTypeById(String userId, String roleType) {
        return dao.changeRoleTypeById(userId, roleType);
    }

}
