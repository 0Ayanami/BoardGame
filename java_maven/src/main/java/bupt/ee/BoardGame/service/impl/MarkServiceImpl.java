package bupt.ee.BoardGame.service.impl;

import bupt.ee.BoardGame.dao.MarkDao;
import bupt.ee.BoardGame.dao.impl.MarkDaoImpl;
import bupt.ee.BoardGame.domain.Mark;
import bupt.ee.BoardGame.service.MarkService;

public class MarkServiceImpl implements MarkService {

    private MarkDao markDao = new MarkDaoImpl();

    /**
     * 判断是否打分
     * @param bid
     * @param uid
     * @return
     */
    @Override
    public Mark myMark(String bid, int uid) {
        Mark mark = markDao.findByBidAndUid(Integer.parseInt(bid), uid);
        return mark;
    }

    /**
     * 打分
     * @param bid
     * @param uid
     */
    @Override
    public void add(String bid, int score, int uid) {
        markDao.add(Integer.parseInt(bid),score, uid);
    }
}
