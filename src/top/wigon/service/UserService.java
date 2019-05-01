package top.wigon.service;

import top.wigon.entity.User;

import java.util.List;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/25 9:46
 **/
public interface UserService {
    /**
     * 用户登录成功与否
     *
     * @return
     */
    Boolean userLoginByphone(User user);

    /**
     * 添加用户返回成功与否
     *
     * @param user
     * @return
     */
    Boolean userAdd(User user);

    /**
     * 用户信息修改
     *
     * @param user
     * @return
     */
    Boolean userEdit(User user);

    /**
     * 删除用户
     *
     * @param user
     * @return
     */
    Boolean userDel(User user);

    /**
     * 检测电话是否已经存在
     *
     * @param tel
     * @return
     */
    Boolean checkTelExist(String tel);

    /**
     * 获取所有用户集合
     *
     * @return
     */
    List<User> getAllUsers();

    /**
     * 通过电话号得到User_ID
     * @return
     */
    public String getUserIDByTel(String tel);
}
