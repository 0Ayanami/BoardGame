package bupt.ee.BoardGame.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 桌游商品实体类
 */
public class BoardGame implements Serializable {
    //一张数据表，对应一个实体类
    //一个实体类，可能会包括该表以外的其他字段
    private int bid;//桌游id，必输
    private String bname;//桌游名称，必输
    private double price;//价格，必输
    private String gameIntroduce;//游戏介绍
    private int count;//销售数量
    private double score;//桌游评分，满分10分

    private int pnumber;//游玩人数

    private String ptime;//建议时间,单位分钟

    private int level;//难度,0~10
    private int cid;//所属分类，必输
    private String bimage;//缩略图


    //非BoardGame表中的字段，而是关联其他表后返回的字段
    //这些所有字段组合在一起，构成了实体类BoardGame
    private Category category;//所属分类

    private List<BoardGameImg> boardGameImgList;//商品详情图片列表

    private List<Comment> commentList;//商品详情评论


    /**
     * 无参构造方法
     */
    public BoardGame() {
    }

    /**
     * 有参构造方法
     *
     * @param bid
     * @param bname
     * @param price
     * @param gameIntroduce
     * @param level
     * @param score
     * @param pnumber
     * @param ptime
     * @param count
     * @param cid
     * @param bimage
     */

    public BoardGame(int bid, String bname, double price, String gameIntroduce, int count, double score, int pnumber, String ptime, int level, int cid, String bimage, String sourceId) {
        this.bid = bid;
        this.bname = bname;
        this.price = price;
        this.gameIntroduce = gameIntroduce;
        this.count = count;
        this.score = score;
        this.pnumber = pnumber;
        this.ptime = ptime;
        this.level = level;
        this.cid = cid;
        this.bimage = bimage;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<BoardGameImg> getBoardGameImgList() {
        return boardGameImgList;
    }

    public void setBoardGameImgList(List<BoardGameImg> boardGameImgList) {
        this.boardGameImgList = boardGameImgList;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGameIntroduce() {
        return gameIntroduce;
    }

    public void setGameIntroduce(String gameIntroduce) {
        this.gameIntroduce = gameIntroduce;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getPnumber() {
        return pnumber;
    }

    public void setPnumber(int pnumber) {
        this.pnumber = pnumber;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getBimage() {
        return bimage;
    }

    public void setBimage(String bimage) {
        this.bimage = bimage;
    }

}
