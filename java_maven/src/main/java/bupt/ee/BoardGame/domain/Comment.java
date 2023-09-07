package bupt.ee.BoardGame.domain;

import java.io.Serializable;

/**
 * 评论类
 */
public class Comment implements Serializable {
    private int bid;//桌游对象

    private String comment;//评论
    private int uid;

    /**
     * 无参构造方法
     */
    public Comment() {
    }
    /**
     * 有参构造方法
     * @param bid
     * @param comment
     * @param uid
     */
    public Comment(int bid, String comment, int uid) {
        this.bid = bid;
        this.comment = comment;
        this.uid = uid;
    }


    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "bid=" + bid +
                ", comment='" + comment + '\'' +
                ", uid=" + uid +
                '}';
    }
}
