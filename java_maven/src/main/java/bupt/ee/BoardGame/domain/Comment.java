package bupt.ee.BoardGame.domain;

import java.io.Serializable;

/**
 * 评论类
 */
public class Comment implements Serializable {
    private BoardGame boardgame;//桌游对象

    private String comment;//评论

    private User user;//评论用户

    /**
     * 无参构造方法
     */
    public Comment() {
    }

    /**
     * 有参构造方法
     * @param boardgame
     * @param comment
     * @param user
     */
    public Comment(BoardGame boardgame, String comment, User user) {
        this.boardgame = boardgame;
        this.comment = comment;
        this.user = user;
    }

    public BoardGame getBoardgame() {
        return boardgame;
    }

    public void setBoardgame(BoardGame boardgame) {
        this.boardgame = boardgame;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
