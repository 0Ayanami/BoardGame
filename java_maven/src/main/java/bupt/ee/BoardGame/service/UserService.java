package bupt.ee.BoardGame.service;

import bupt.ee.BoardGame.domain.User;

public interface UserService {

    /**
     * 注册用户check
     * @param user
     * @return
     */
    Boolean regist(User user);

    /**
     * 激活方法check
     * @param code
     * @return
     */
    boolean active(String code);

    /**
     * check
     * 判断用户登录
     * @param user
     * @return
     */
    User login(User user);
}
