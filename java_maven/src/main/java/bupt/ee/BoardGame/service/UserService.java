package bupt.ee.BoardGame.service;

import bupt.ee.BoardGame.domain.User;

public interface UserService {

    /**
     * 注册用户
     * @param user
     * @return
     */
    Boolean regist(User user);

    /**
     * 激活方法
     * @param code
     * @return
     */
    boolean active(String code);

    /**
     * 判断用户登录
     * @param user
     * @return
     */
    User login(User user);
}
