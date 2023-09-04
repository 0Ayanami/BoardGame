package bupt.ee.BoardGame.service;

public interface MarkService {
    /**
     * 判断是否打分
     * @param bid
     * @param uid
     * @return
     */
    public boolean isMark(String bid,int uid);

    /**
     * 打分
     * @param bid
     * @param uid
     */
    public void add(String bid, int score, int uid);
}
