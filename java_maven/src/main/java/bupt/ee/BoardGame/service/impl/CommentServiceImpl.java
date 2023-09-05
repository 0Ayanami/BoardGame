package bupt.ee.BoardGame.service.impl;

import bupt.ee.BoardGame.dao.CommentDao;
import bupt.ee.BoardGame.dao.impl.CommentDaoImpl;
import bupt.ee.BoardGame.domain.Comment;
import bupt.ee.BoardGame.service.CommentService;

public class CommentServiceImpl implements CommentService {
    private CommentDao commentDao = new CommentDaoImpl();

    /**
     * 添加评论
     * @param bid
     * @param comment
     * @param uid
     * @return
     */
    @Override
    public void addComment(String bid, String comment, int uid) {
        commentDao.addComment(Integer.parseInt(bid), comment, uid);
    }
}
