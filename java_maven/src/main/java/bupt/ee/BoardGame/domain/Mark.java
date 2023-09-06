package bupt.ee.BoardGame.domain;

import java.io.Serializable;

/**
 * 评分实体类
 */
public class Mark implements Serializable {

    private int uid;
    private int bid;
    private int score;//评价分数0~10
    private User user;//所属用户
    private BoardGame boardgame;//桌游对象
    /**
     * 无参构造方法
     */
    public Mark() {
    }

    /**
     * 有参构造方法
     * @param score
     * @param uid
     */
    public Mark(int uid,int bid, int score) {
            this.score = score;
            this.bid = bid;
            this.uid =uid;
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

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "bid=" + bid +
                ", uid=" + uid +
                ", score=" + score +
                '}';
    }
}
