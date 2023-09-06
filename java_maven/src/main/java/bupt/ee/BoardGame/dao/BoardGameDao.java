package bupt.ee.BoardGame.dao;

import bupt.ee.BoardGame.domain.BoardGame;

import java.util.List;
import java.util.Map;

public interface BoardGameDao {
    /**
     * check
     * 根据cid查询总记录数
     * @param cid
     * @return
     */
    public int findTotalCount(int cid,String bname);

    /**
     * check
     * 根据cid，start，pageSize查询当前的数据集合
     * @param cid
     * @param start
     * @param pageSize
     * @return
     */
    public List<BoardGame> findByPage(int cid,int start,int pageSize,String bname);

    /**
     * 根据bid查询boardgame表记录（BoardGame实体类的部分数据）
     * @param bid
     * @return
     */
    public BoardGame findOne(int bid);

    public List<Map<String, Object>> findAll();
}
