package bupt.ee.BoardGame.dao;

import bupt.ee.BoardGame.domain.Seller;

public interface SellerDao {
    /**
     * 根据id查询
     * @param sid
     * @return
     */
    public Seller findById(int sid);
}
