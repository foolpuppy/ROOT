package top.wigon.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/24 21:29
 **/
public class Order implements Serializable {
    private String orderId;
    private String userId;
    private BigDecimal payment;
    private int paymentType;
    private BigDecimal postFee;
    private int orderState;
    /**
     *  订单创建时间
     */

    private String orderCreateTime;
    /**
     * 订单支付时间
     */
    private String paymentTime;
    /**
     * 发货时间
     */
    private String consignTime;
    private String receiveTime;
    /**
     * 订单结束时间
     */
    private String endTime;
    /**
     * 订单关闭时间
     */
    private String closeTime;
    /**
     * 物流公司以及物流号
     */
    private String shippingName;
    private String shipingCode;
    private String createTime;

    public Order() {
    }

    public Order(String orderId, String userId, BigDecimal payment, int paymentType, BigDecimal postFee, int orderState, String orderCreateTime, String paymentTime, String consignTime, String receiveTime, String endTime, String closeTime, String shippingName, String shipingCode, String createTime) {
        this.orderId = orderId;
        this.userId = userId;
        this.payment = payment;
        this.paymentType = paymentType;
        this.postFee = postFee;
        this.orderState = orderState;
        this.orderCreateTime = orderCreateTime;
        this.paymentTime = paymentTime;
        this.consignTime = consignTime;
        this.receiveTime = receiveTime;
        this.endTime = endTime;
        this.closeTime = closeTime;
        this.shippingName = shippingName;
        this.shipingCode = shipingCode;
        this.createTime = createTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getPostFee() {
        return postFee;
    }

    public void setPostFee(BigDecimal postFee) {
        this.postFee = postFee;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public String getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(String orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getConsignTime() {
        return consignTime;
    }

    public void setConsignTime(String consignTime) {
        this.consignTime = consignTime;
    }

    public String getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(String receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getShippingName() {
        return shippingName;
    }

    public void setShippingName(String shippingName) {
        this.shippingName = shippingName;
    }

    public String getShipingCode() {
        return shipingCode;
    }

    public void setShipingCode(String shipingCode) {
        this.shipingCode = shipingCode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", userId='" + userId + '\'' +
                ", payment=" + payment +
                ", paymentType=" + paymentType +
                ", postFee=" + postFee +
                ", orderState=" + orderState +
                ", orderCreateTime='" + orderCreateTime + '\'' +
                ", paymentTime='" + paymentTime + '\'' +
                ", consignTime='" + consignTime + '\'' +
                ", receiveTime='" + receiveTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", closeTime='" + closeTime + '\'' +
                ", shippingName='" + shippingName + '\'' +
                ", shipingCode='" + shipingCode + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
