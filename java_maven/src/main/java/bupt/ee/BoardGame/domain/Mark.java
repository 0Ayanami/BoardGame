package bupt.ee.BoardGame.domain;

import java.io.Serializable;

/**
 * 评分实体类
 */
public class Mark implements Serializable {
    private BoardGame boardgame;//桌游对象
    private int score;//评价分数0~10
    private User user;//所属用户

    /**
     * 无参构造方法
     */
    public Mark() {
    }

    /**
     * 有参构造方法
     * @param boardgame
     * @param score
     * @param user
     */
    public Mark(BoardGame boardgame, int score, User user) {
            this.boardgame = boardgame;
            this.score = score;
            this.user = user;
    }

    public BoardGame getBoardgame() {
        return boardgame;
    }

    public void setBoardgame(BoardGame boardgame) {
        this.boardgame = boardgame;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "boardgame=" + boardgame +
                ", score=" + score +
                ", user=" + user +
                '}';
    }
}
