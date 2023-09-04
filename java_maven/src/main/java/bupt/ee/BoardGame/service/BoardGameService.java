package bupt.ee.BoardGame.service;

import bupt.ee.BoardGame.domain.PageBean;
import bupt.ee.BoardGame.domain.BoardGame;

/**
 * 游戏service
 */
public interface BoardGameService {
    /**
     * 根据类别进行分页查询
     * @param cid
     * @param currentPage
     * @param pageSize
     * @return
     */
    public PageBean<BoardGame> PageQuery(int cid,int currentPage,int pageSize,String bname);

    /**
     * 根据bid查询BoardGame实体类
     * @param bid
     * @return
     */
    public BoardGame findOne(String bid);
}
