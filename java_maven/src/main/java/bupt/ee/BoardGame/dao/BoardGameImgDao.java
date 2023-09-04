package bupt.ee.BoardGame.dao;

import bupt.ee.BoardGame.domain.BoardGame;
import bupt.ee.BoardGame.domain.BoardGameImg;

import java.util.List;

public interface BoardGameImgDao {
    /**
     * 通过boardgame的bid查询图片
     * @return
     */
    public List<BoardGameImg> findByBid(int bid);
}
