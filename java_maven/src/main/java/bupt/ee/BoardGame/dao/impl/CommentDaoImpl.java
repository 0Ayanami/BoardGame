package bupt.ee.BoardGame.dao.impl;

import bupt.ee.BoardGame.dao.CommentDao;
import bupt.ee.BoardGame.domain.BoardGameImg;
import bupt.ee.BoardGame.domain.Comment;
import bupt.ee.BoardGame.domain.Mark;
import bupt.ee.BoardGame.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CommentDaoImpl implements CommentDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public void addComment(int bid, String comment, int uid) {
        String sql = " insert into comment values(?,?,?) ";
        template.update(sql, bid, uid, comment);
    }

    @Override
    public List<Comment> findByBid(int bid) {
        String sql = "select * from comment where bid = ? ";

        return template.query(sql,new BeanPropertyRowMapper<Comment>(Comment.class),bid);
    }
}
