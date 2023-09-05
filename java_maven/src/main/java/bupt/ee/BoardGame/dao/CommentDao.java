package bupt.ee.BoardGame.dao;

import bupt.ee.BoardGame.domain.Comment;

import java.util.List;

public interface CommentDao {
    /**
     *添加评论
     * @param bid
     * @param comment
     * @param uid
     * @return
     */
    public void addComment(int bid, String comment, int uid);

    /**
     * 根据bid返回某商品的所有评论集合
     * @param bid
     * @return
     */
    public List<Comment> findByBid(int bid);
}
