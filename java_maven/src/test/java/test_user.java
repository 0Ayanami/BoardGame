import bupt.ee.BoardGame.dao.UserDao;
import bupt.ee.BoardGame.dao.impl.*;
import bupt.ee.BoardGame.domain.*;
import bupt.ee.BoardGame.service.BoardGameService;
import bupt.ee.BoardGame.service.impl.*;
import bupt.ee.BoardGame.util.JDBCUtils;
import bupt.ee.BoardGame.web.servlet.UserServlet;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class test_user {
    private CommentDaoImpl commentDao = new CommentDaoImpl();
    private UserDao userDao = new UserDaoImpl();
    private BoardGameDaoImpl boardGameDao = new BoardGameDaoImpl();
    private PurchaseDaoImpl purchaseDao = new PurchaseDaoImpl();
    private MarkDaoImpl markDao = new MarkDaoImpl();
    private BoardGameImgDaoImpl boardGameImgDao = new BoardGameImgDaoImpl();
    private CategoryDaoImpl categoryDao = new CategoryDaoImpl();
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public static void main(String[] args) {
        test_user test_user = new test_user();
        User user = new User(2021211311, "Tom", "2021211311", "email", "Y", "o");
        test_user.Test_(user);
    }

    public void Test_(User user) {
        //定义sql
        String sql = "insert into user " +
                "values(?,?,?,?,?,?)";
        //执行sql
        System.out.println(sql);
        template.update(sql, user.getUid(), user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getStatus(),
                user.getCode()
        );
    }

    @Test


    public void Test__() {
        String sql = " select * from user where uid =?";
        User user_ = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), 2021211319);
        System.out.println(user_);

    }

    @Test
    public void test___() {
        BoardGame boardGame = boardGameDao.findOne(1);
        System.out.println(boardGame);
    }

    @Test
    public void test_activeUserServlet() {
        List<Comment> list = commentDao.findByBid(1);
        System.out.println(list);
    }

    @Test
    public void test_boardGame() {
        List<BoardGame> list = boardGameDao.findByPage(1, 1, 2
                , null);
        System.out.println(list);
    }

    @Test
    public void test_category() {
        List<Category> list = categoryDao.findAll();
        System.out.println(list);
    }

    @Test
    public void test_Img() {
        List<BoardGameImg> list = boardGameImgDao.findByBid(1);
        System.out.println(list);
    }

    private UserServlet userServlet = new UserServlet();
    private UserServiceImpl userService = new UserServiceImpl();
    private PurchaseServiceImpl purchaseService =new PurchaseServiceImpl();
    private MarkServiceImpl markService = new MarkServiceImpl();
    private CommentServiceImpl commentService = new CommentServiceImpl();
    private CategoryServiceImpl categoryService =new CategoryServiceImpl();
    private BoardGameServiceImpl boardGameService =new BoardGameServiceImpl();
    @Test
    public void test_userServlet() {
        BoardGame boardGame= null;

        PageBean<BoardGame> pageBean = boardGameService.PageQuery(1,1,1,"工业革命：伯明翰");
        System.out.println(pageBean);
    }
}

