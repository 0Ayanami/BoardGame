package bupt.ee.BoardGame.dao.impl;

import bupt.ee.BoardGame.dao.PurchaseDao;
import bupt.ee.BoardGame.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class PurchaseDaoImpl implements PurchaseDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 购买
     * @param bid
     */
    public void buy(int bid){
        String sql = "update boardgame set count = count + 1 where bid = ?";
        try {
            template.update(sql, bid);
        }catch (DataAccessException e){

        }
    }

    /**
     * 查看桌游的销量
     * @param bid
     * @return
     */
    @Override
    public int findCountByBid(int bid) {
        String sql = " select count from boardgame where bid = ? ";
        return template.queryForObject(sql,Integer.class,bid);
    }
}
