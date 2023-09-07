import bupt.ee.BoardGame.dao.UserDao;
import bupt.ee.BoardGame.dao.impl.UserDaoImpl;
import bupt.ee.BoardGame.domain.User;
import bupt.ee.BoardGame.util.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class test_db {
    private UserDao userDao = new UserDaoImpl();
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public static void main(String[] args) {
        test_db test_user = new test_db();
        test_user.Test_();
    }
    public void Test_(){

        User u = userDao.findByUsername("2021211319");
        System.out.println(u);
    }

    public void Test__(){
        String sql = "update user set status = 'Y' where uid = ?";
        template.update(sql,2021211319);
    }
}