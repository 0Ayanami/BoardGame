package bupt.ee.BoardGame.dao;

import bupt.ee.BoardGame.domain.Mark;

public interface MarkDao {
    /**
     * 根据bid和uid查询桌游信息
     * @param bid
     * @param uid
     * @return
     */
    public Mark findByBidAndUid(int bid,int uid);


    /**
     * 打分
     * @param bid
     * @param uid
     */
    void add(int bid, int score, int uid);
}
