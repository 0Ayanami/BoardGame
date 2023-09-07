package bupt.ee.BoardGame.dao.impl;

import bupt.ee.BoardGame.dao.UserDao;
import bupt.ee.BoardGame.domain.User;
import bupt.ee.BoardGame.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {

    //开启数据库连接
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    @Override
    public User findByUsername(String username) {
        User user = null;
        try {
            //定义sql
            String sql = "select * from user where username = ?";
            //执行sql
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),username);
        } catch (Exception e) {
            // 不打印捕获的异常，这里的异常是user未查询到的异常
        }
        return user;
    }

    /**
     * 用户保存
     *
     * @param user
     */
    @Override
    public void save(User user) {
        //定义sql
        String sql = "insert into user " +
                "values(?,?,?,?,?,?)";
        //执行sql
        template.update(sql,user.getUid(), user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getStatus(),
                user.getCode()
        );

    }
    /**
     * check
     * 根据用户激活码查询用户对象
     * @param code
     * @return
     */
    @Override
    public User findByCode(String code) {
        User user=null;
        try {
            String sql = "select * from user where code = ?";
            user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),code);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return user;
    }
    /**
     * 修改指定用户激活状态
     * @param user
     */
    @Override
    public void updateStatus(User user) {
        String sql = "update user set status = 'Y' where uid = ?";
        template.update(sql,user.getUid());
    }
    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user = null;
        try {
            //1.定义sql
            String sql = "select * from user where username = ? and password = ?";
            //2.执行sql
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),username,password);
        } catch (Exception e) {
            // 不打印捕获的异常，这里的异常是user未查询到的异常
            // 如果未查询到user是会控制台打印异常信息的，但是这里的异常信息我们做了处理
            // 也就是提前做了即使是异常该怎么解决的代码逻辑
            // e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findByUid(int uid) {
        User user = null;
        String sql = "select * from user where uid = ?";
        user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),uid);
        return user;
    }
    @Override
    public int generateUid(){
        String sql = "select max(uid) from user";
        int userUid  = template.queryForObject(sql,Integer.class );
        return userUid;
    }
}