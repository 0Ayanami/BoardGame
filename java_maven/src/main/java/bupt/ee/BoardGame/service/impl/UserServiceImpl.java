package bupt.ee.BoardGame.service.impl;

import bupt.ee.BoardGame.dao.UserDao;
import bupt.ee.BoardGame.dao.impl.UserDaoImpl;
import bupt.ee.BoardGame.domain.User;
import bupt.ee.BoardGame.service.UserService;
import bupt.ee.BoardGame.util.MailUtils;
import bupt.ee.BoardGame.util.UuidUtil;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public Boolean regist(User user) {
        //根据用户名查询用户对象
        User u = userDao.findByUsername(user.getUsername());
        //判断null是否为null
        if (u != null){
            //用户名存在，注册失败
            return false;
        }
        //保存用户信息
        //设置激活码，唯一字符串
        user.setCode(UuidUtil.getUuid());
        //设置激活状态
        user.setStatus("N");
        userDao.save(user);

        //激活邮件发送邮件正文
        String content="<a href='http://localhost/boardgame/user/active?code="+user.getCode()+"'>点击激活账号</a>";
        //调用邮件发送
        MailUtils.sendMail(user.getEmail(),content,"激活邮件");
        return true;
    }

    /**
     * 激活用户
     * @param code
     * @return
     */
    @Override
    public boolean active(String code) {
        //根据用户激活码查询用户对象
        User user = userDao.findByCode(code);
        if (user!=null){
            //调用dao的修改激活状态的方法
            userDao.updateStatus(user);
            return true;
        }else {
            return false;
        }

    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return userDao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }
}