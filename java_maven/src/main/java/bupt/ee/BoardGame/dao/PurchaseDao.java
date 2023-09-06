package bupt.ee.BoardGame.dao;

public interface PurchaseDao {
    /**
     *check
     * 购买
     * @param bid
     */
    public void buy(int bid);

    /**
     *check
     * 查看桌游的销量
     * @param bid
     * @return
     */
    public int findCountByBid(int bid);
}
