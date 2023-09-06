package bupt.ee.BoardGame.service;

import bupt.ee.BoardGame.domain.Comment;

public interface CommentService {
    /**
     * check
     * 添加评论
     * @param bid
     * @param comment
     * @param uid
     * @return
     */
    public void addComment(String bid, String comment, int uid);
}
