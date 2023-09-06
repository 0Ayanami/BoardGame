package bupt.ee.BoardGame.dao;

import bupt.ee.BoardGame.domain.User;

public interface UserDao {
    /**
     * check
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public User findByUsername(String username);

    /**
     * check
     * 用户保存
     * @param user
     */
    public void save(User user);

    /**
     * check
     * 根据用户激活码查询用户对象
     * @param code
     * @return
     */
    User findByCode(String code);

    /**
     *check
     * 修改指定用户激活状态 check
     * @param user
     */

    void updateStatus(User user);

    /**
     * check
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    User findByUsernameAndPassword(String username, String password);

    User findByUid(int uid);
}
