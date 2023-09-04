package bupt.ee.BoardGame.service.impl;

import bupt.ee.BoardGame.dao.MarkDao;
import bupt.ee.BoardGame.dao.BoardGameDao;
import bupt.ee.BoardGame.dao.BoardGameImgDao;
import bupt.ee.BoardGame.dao.impl.MarkDaoImpl;
import bupt.ee.BoardGame.dao.impl.BoardGameDaoImpl;
import bupt.ee.BoardGame.dao.impl.BoardGameImgDaoImpl;
import bupt.ee.BoardGame.domain.PageBean;
import bupt.ee.BoardGame.domain.BoardGame;
import bupt.ee.BoardGame.domain.BoardGameImg;
import bupt.ee.BoardGame.service.BoardGameService;

import java.util.List;

public class BoardGameServiceImpl implements BoardGameService {

    private BoardGameDao boardgameDao = new BoardGameDaoImpl();

    private BoardGameImgDao boardgameImgDao = new BoardGameImgDaoImpl();

    private MarkDao markDao = new MarkDaoImpl();

    /**
     * 根据类别进行分页查询
     * @param cid
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageBean<BoardGame> PageQuery(int cid, int currentPage, int pageSize,String bname) {
        //封装PageBean
        PageBean<BoardGame> pb = new PageBean<>();

        //设置当前页码
        pb.setCurrentPage(currentPage);

        //设置每页显示条数
        pb.setPageSize(pageSize);

        //设置总记录数
        int totalCount = boardgameDao.findTotalCount(cid,bname);
        pb.setTotalCount(totalCount);

        //设置当前页显示的数据集合
        int start = (currentPage - 1) * pageSize;//开始的记录数
        List<BoardGame> list = boardgameDao.findByPage(cid, start, pageSize,bname);
        pb.setList(list);

        //设置总页数 = 总记录数/每页显示条数
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize:(totalCount / pageSize)+1;
        pb.setTotalPage(totalPage);

        return pb;
    }

    /**
     * 根据bid查询BoardGame实体类
     * @param bid
     * @return
     */
    @Override
    public BoardGame findOne(String bid) {
        //根据bid去BoardGame表中查询BoardGame对象
        BoardGame boardgame = boardgameDao.findOne(Integer.parseInt(bid));
        //根据BoardGame的bid去查询图片集合信息（关联图片表）
        List<BoardGameImg> boardgameImgs = boardgameImgDao.findByBid(boardgame.getBid());
        //将集合设置到BoardGame对象
        boardgame.setBoardGameImgList(boardgameImgs);
        //查询桌游评分
        int score = markDao.findScoreByBid(boardgame.getBid());
        boardgame.setScore(score);

        return boardgame;
    }


}
