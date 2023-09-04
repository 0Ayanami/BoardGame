package bupt.ee.BoardGame.dao.impl;

import bupt.ee.BoardGame.dao.SellerDao;
import bupt.ee.BoardGame.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class SellerDaoImpl implements SellerDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 根据id查询
     * @param sid
     * @return
     */
    @Override
    public Seller findById(int sid) {
        String sql = "select * from tab_seller where sid = ? ";

        return template.queryForObject(sql,new BeanPropertyRowMapper<Seller>(Seller.class),sid);
    }
}
