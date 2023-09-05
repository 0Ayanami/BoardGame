package bupt.ee.BoardGame.dao.impl;

import bupt.ee.BoardGame.dao.BoardGameImgDao;
import bupt.ee.BoardGame.domain.BoardGame;
import bupt.ee.BoardGame.domain.BoardGameImg;
import bupt.ee.BoardGame.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BoardGameImgDaoImpl implements BoardGameImgDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 通过boardgame的bid查询图片
     * @return
     */
    @Override
    public List<BoardGameImg> findByBid(int bid) {
        String sql = "select * from boardgame_img where bid = ? ";

        return template.query(sql,new BeanPropertyRowMapper<BoardGameImg>(BoardGameImg.class),bid);
    }
}
