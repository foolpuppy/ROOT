package top.wigon.entity;

import java.math.BigDecimal;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/24 22:14
 **/
public class AlipayDetail {
    private int id;
    private String orderId;
    private String buyerId;
    private String sellerId;
    private String sellerTradeNo;
    private String alipayTradeNo;
    private BigDecimal payment;
    private String createTime;

    public AlipayDetail() {
    }

    public AlipayDetail(int id, String orderId, String buyerId, String sellerId, String sellerTradeNo, String alipayTradeNo, BigDecimal payment, String createTime) {
        this.id = id;
        this.orderId = orderId;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.sellerTradeNo = sellerTradeNo;
        this.alipayTradeNo = alipayTradeNo;
        this.payment = payment;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerTradeNo() {
        return sellerTradeNo;
    }

    public void setSellerTradeNo(String sellerTradeNo) {
        this.sellerTradeNo = sellerTradeNo;
    }

    public String getAlipayTradeNo() {
        return alipayTradeNo;
    }

    public void setAlipayTradeNo(String alipayTradeNo) {
        this.alipayTradeNo = alipayTradeNo;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
