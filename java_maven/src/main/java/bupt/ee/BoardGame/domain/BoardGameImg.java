package bupt.ee.BoardGame.domain;

import java.io.Serializable;

/**
 * 旅游线路图片实体类
 */
public class BoardGameImg implements Serializable {
    private int bpid;//商品图片id
    private int bid;//桌游商品id
    private String bigPic;//详情商品大图
    private String smallPic;//详情商品小图

    /**
     * 无参构造方法
     */
    public BoardGameImg() {
    }

    /**
     * 有参构造方法
     * @param bpid
     * @param bid
     * @param bigPic
     * @param smallPic
     */
    public BoardGameImg(int bpid, int bid, String bigPic, String smallPic) {
        this.bpid = bpid;
        this.bid = bid;
        this.bigPic = bigPic;
        this.smallPic = smallPic;
    }

    public int getBpid() {
        return bpid;
    }

    public void setBpid(int bpid) {
        this.bpid = bpid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBigPic() {
        return bigPic;
    }

    public void setBigPic(String bigPic) {
        this.bigPic = bigPic;
    }

    public String getSmallPic() {
        return smallPic;
    }

    public void setSmallPic(String smallPic) {
        this.smallPic = smallPic;
    }

    @Override
    public String toString() {
        return "BoardGameImg{" +
                "bpid=" + bpid +
                ", bid=" + bid +
                ", bigPic='" + bigPic + '\'' +
                ", smallPic='" + smallPic + '\'' +
                '}';
    }
}
