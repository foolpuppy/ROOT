package top.wigon.service;

import top.wigon.entity.User;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/25 9:46
 **/
public interface UserService {
    /**
     * 用户登录成功与否
     * @return
     */
    Boolean userLoginByphone(User user);
}
