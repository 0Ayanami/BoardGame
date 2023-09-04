package bupt.ee.BoardGame.service;

import bupt.ee.BoardGame.domain.Mark;

public interface MarkService {
    /**
     * 判断是否打分
     * @param bid
     * @param uid
     * @return
     */
    public Mark myMark(String bid, int uid);

    /**
     * 打分
     * @param bid
     * @param uid
     */
    public void add(String bid, int score, int uid);
}
