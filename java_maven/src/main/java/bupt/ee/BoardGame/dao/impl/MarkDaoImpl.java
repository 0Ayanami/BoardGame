package bupt.ee.BoardGame.dao.impl;

import bupt.ee.BoardGame.dao.MarkDao;
import bupt.ee.BoardGame.domain.BoardGame;
import bupt.ee.BoardGame.domain.Mark;
import bupt.ee.BoardGame.domain.User;
import bupt.ee.BoardGame.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;


public class MarkDaoImpl implements MarkDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    private BoardGameDaoImpl boardGameDao = new BoardGameDaoImpl();

    private UserDaoImpl userDao = new UserDaoImpl();
    /**
     * mark
     * 根据bid和uid查询桌游信息
     * @param bid
     * @param uid
     * @return
     */
    @Override
    public Mark findByBidAndUid(int bid, int uid) {
        Mark mark = null;

        try {
            String sql = " select * from mark where bid = ? and uid = ? ";
            mark = template.queryForObject(sql,new BeanPropertyRowMapper<Mark>(Mark.class),bid,uid);
            int Bid = mark.getBid();
            int Uid = mark.getUid();
            BoardGame boardGame = boardGameDao.findOne(Bid);
            User user = userDao.findByUid(Uid);
            mark.setBoardgame(boardGame);
            mark.setUser(user);

        } catch (DataAccessException e) {
            //e.printStackTrace();
        }

        return mark;
    }

    /**
     * mark
     * 打分
     * @param bid
     * @param uid
     */
    @Override
    public void add(int bid, int score, int uid) {
        String sql = " insert into mark values(?,?,?) ";
        String sql_update = " update mark set score = ? where bid =? and uid=?";
        try {
            template.update(sql, bid, uid, score);
        }catch (Exception e){
            template.update(sql_update, score, bid, uid);

        }
    }
}
