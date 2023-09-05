package bupt.ee.BoardGame.dao;

public interface PurchaseDao {
    /**
     * 购买
     * @param bid
     */
    public void buy(int bid);

    /**
     * 查看桌游的销量
     * @param bid
     * @return
     */
    public int findCountByBid(int bid);
}
