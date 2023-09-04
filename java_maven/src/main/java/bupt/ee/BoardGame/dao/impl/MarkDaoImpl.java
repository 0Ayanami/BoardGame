package bupt.ee.BoardGame.dao.impl;

import bupt.ee.BoardGame.dao.MarkDao;
import bupt.ee.BoardGame.domain.Mark;
import bupt.ee.BoardGame.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class MarkDaoImpl implements MarkDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
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
        } catch (DataAccessException e) {
            //e.printStackTrace();
        }
        return mark;
    }

    /**
     * 查看桌游的分数
     * @param bid
     * @return
     */
    @Override
    public int findScoreByBid(int bid) {
        String sql = " select score from mark where bid = ? ";
        return template.queryForObject(sql,Integer.class,bid);
    }

    /**
     * 打分
     * @param bid
     * @param uid
     */
    @Override
    public void add(int bid, int score, int uid) {
        String sql = " insert into mark values(?,?,?) ";
        template.update(sql,bid,score,uid);
    }
}
