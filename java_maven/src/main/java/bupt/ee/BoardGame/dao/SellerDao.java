package bupt.ee.BoardGame.dao;

public interface SellerDao {
    /**
     * 根据id查询
     * @param sid
     * @return
     */
    public Seller findById(int sid);
}
