package top.wigon.entity;

import java.io.Serializable;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/24 21:39
 **/
public class Shipping implements Serializable {
    private String id;
    private String orderId;
    private String receiverName;
    private String receiverTel;
    private String receiverState;
    private String receiverCity;
    private String receiverDistrict;
    private String receiverAddress;
    private String receiverZip;
    private String currLoc;
    private String createTime;

    public Shipping() {
    }

    public Shipping(String id, String orderId, String receiverName, String receiverTel, String receiverState, String receiverCity, String receiverDistrict, String receiverAddress, String receiverZip, String currLoc, String createTime) {
        this.id = id;
        this.orderId = orderId;
        this.receiverName = receiverName;
        this.receiverTel = receiverTel;
        this.receiverState = receiverState;
        this.receiverCity = receiverCity;
        this.receiverDistrict = receiverDistrict;
        this.receiverAddress = receiverAddress;
        this.receiverZip = receiverZip;
        this.currLoc = currLoc;
        this.createTime = createTime;
    }

    public String getCurrLoc() {
        return currLoc;
    }

    public void setCurrLoc(String currLoc) {
        this.currLoc = currLoc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverTel() {
        return receiverTel;
    }

    public void setReceiverTel(String receiverTel) {
        this.receiverTel = receiverTel;
    }

    public String getReceiverState() {
        return receiverState;
    }

    public void setReceiverState(String receiverState) {
        this.receiverState = receiverState;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverDistrict() {
        return receiverDistrict;
    }

    public void setReceiverDistrict(String receiverDistrict) {
        this.receiverDistrict = receiverDistrict;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverZip() {
        return receiverZip;
    }

    public void setReceiverZip(String receiverZip) {
        this.receiverZip = receiverZip;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
