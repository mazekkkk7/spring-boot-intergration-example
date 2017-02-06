package cn.mazekkkk.product.dao.common;

import javax.persistence.*;
import java.util.Date;

@Table(name = "gametrade")
public class Gametrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "connectorNo")
    private String connectorno;

    /**
     * 所属门店
     */
    @Column(name = "partnerId")
    private String partnerid;

    @Column(name = "gamesBoxId")
    private String gamesboxid;

    @Column(name = "gamesId")
    private String gamesid;

    @Column(name = "openId")
    private String openid;

    @Column(name = "clubCardId")
    private String clubcardid;

    @Column(name = "orderTime")
    private Date ordertime;

    @Column(name = "payTime")
    private Date paytime;

    /**
     * 01：微信，02：支付宝
     */
    @Column(name = "payMode")
    private Integer paymode;

    @Column(name = "tradeType")
    private Integer tradetype;

    @Column(name = "tradeState")
    private Integer tradestate;

    /**
     * 交易场景1：线上 2：线下
     */
    @Column(name = "tradeScene")
    private Integer tradescene;

    @Column(name = "payAmount")
    private Integer payamount;

    private Integer coin;

    /**
     * 剩余币数
     */
    @Column(name = "remainCoin")
    private Integer remaincoin;

    /**
     * 开启局数
     */
    @Column(name = "gameTimes")
    private Integer gametimes;

    /**
     * 优惠方式（1，优惠券）
     */
    @Column(name = "discountType")
    private Integer discounttype;

    /**
     * 优惠内容（优惠券ID）
     */
    @Column(name = "discountId")
    private String discountid;

    /**
     * 优惠金额
     */
    @Column(name = "discountAmt")
    private Integer discountamt;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return connectorNo
     */
    public String getConnectorno() {
        return connectorno;
    }

    /**
     * @param connectorno
     */
    public void setConnectorno(String connectorno) {
        this.connectorno = connectorno == null ? null : connectorno.trim();
    }

    /**
     * 获取所属门店
     *
     * @return partnerId - 所属门店
     */
    public String getPartnerid() {
        return partnerid;
    }

    /**
     * 设置所属门店
     *
     * @param partnerid 所属门店
     */
    public void setPartnerid(String partnerid) {
        this.partnerid = partnerid == null ? null : partnerid.trim();
    }

    /**
     * @return gamesBoxId
     */
    public String getGamesboxid() {
        return gamesboxid;
    }

    /**
     * @param gamesboxid
     */
    public void setGamesboxid(String gamesboxid) {
        this.gamesboxid = gamesboxid == null ? null : gamesboxid.trim();
    }

    /**
     * @return gamesId
     */
    public String getGamesid() {
        return gamesid;
    }

    /**
     * @param gamesid
     */
    public void setGamesid(String gamesid) {
        this.gamesid = gamesid == null ? null : gamesid.trim();
    }

    /**
     * @return openId
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * @param openid
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * @return clubCardId
     */
    public String getClubcardid() {
        return clubcardid;
    }

    /**
     * @param clubcardid
     */
    public void setClubcardid(String clubcardid) {
        this.clubcardid = clubcardid == null ? null : clubcardid.trim();
    }

    /**
     * @return orderTime
     */
    public Date getOrdertime() {
        return ordertime;
    }

    /**
     * @param ordertime
     */
    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    /**
     * @return payTime
     */
    public Date getPaytime() {
        return paytime;
    }

    /**
     * @param paytime
     */
    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    /**
     * 获取01：微信，02：支付宝
     *
     * @return payMode - 01：微信，02：支付宝
     */
    public Integer getPaymode() {
        return paymode;
    }

    /**
     * 设置01：微信，02：支付宝
     *
     * @param paymode 01：微信，02：支付宝
     */
    public void setPaymode(Integer paymode) {
        this.paymode = paymode;
    }

    /**
     * @return tradeType
     */
    public Integer getTradetype() {
        return tradetype;
    }

    /**
     * @param tradetype
     */
    public void setTradetype(Integer tradetype) {
        this.tradetype = tradetype;
    }

    /**
     * @return tradeState
     */
    public Integer getTradestate() {
        return tradestate;
    }

    /**
     * @param tradestate
     */
    public void setTradestate(Integer tradestate) {
        this.tradestate = tradestate;
    }

    /**
     * 获取交易场景1：线上 2：线下
     *
     * @return tradeScene - 交易场景1：线上 2：线下
     */
    public Integer getTradescene() {
        return tradescene;
    }

    /**
     * 设置交易场景1：线上 2：线下
     *
     * @param tradescene 交易场景1：线上 2：线下
     */
    public void setTradescene(Integer tradescene) {
        this.tradescene = tradescene;
    }

    /**
     * @return payAmount
     */
    public Integer getPayamount() {
        return payamount;
    }

    /**
     * @param payamount
     */
    public void setPayamount(Integer payamount) {
        this.payamount = payamount;
    }

    /**
     * @return coin
     */
    public Integer getCoin() {
        return coin;
    }

    /**
     * @param coin
     */
    public void setCoin(Integer coin) {
        this.coin = coin;
    }

    /**
     * 获取剩余币数
     *
     * @return remainCoin - 剩余币数
     */
    public Integer getRemaincoin() {
        return remaincoin;
    }

    /**
     * 设置剩余币数
     *
     * @param remaincoin 剩余币数
     */
    public void setRemaincoin(Integer remaincoin) {
        this.remaincoin = remaincoin;
    }

    /**
     * 获取开启局数
     *
     * @return gameTimes - 开启局数
     */
    public Integer getGametimes() {
        return gametimes;
    }

    /**
     * 设置开启局数
     *
     * @param gametimes 开启局数
     */
    public void setGametimes(Integer gametimes) {
        this.gametimes = gametimes;
    }

    /**
     * 获取优惠方式（1，优惠券）
     *
     * @return discountType - 优惠方式（1，优惠券）
     */
    public Integer getDiscounttype() {
        return discounttype;
    }

    /**
     * 设置优惠方式（1，优惠券）
     *
     * @param discounttype 优惠方式（1，优惠券）
     */
    public void setDiscounttype(Integer discounttype) {
        this.discounttype = discounttype;
    }

    /**
     * 获取优惠内容（优惠券ID）
     *
     * @return discountId - 优惠内容（优惠券ID）
     */
    public String getDiscountid() {
        return discountid;
    }

    /**
     * 设置优惠内容（优惠券ID）
     *
     * @param discountid 优惠内容（优惠券ID）
     */
    public void setDiscountid(String discountid) {
        this.discountid = discountid == null ? null : discountid.trim();
    }

    /**
     * 获取优惠金额
     *
     * @return discountAmt - 优惠金额
     */
    public Integer getDiscountamt() {
        return discountamt;
    }

    /**
     * 设置优惠金额
     *
     * @param discountamt 优惠金额
     */
    public void setDiscountamt(Integer discountamt) {
        this.discountamt = discountamt;
    }
}