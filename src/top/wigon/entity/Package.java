package top.wigon.entity;

/**
 * @author L
 * @version 1.0
 * @date 2019/5/3 11:44
 **/
public class Package {
    String orderid;
    String imgPath;
    String itemTitle;
    String itemCategory;
    String itemId;
    int itemNums;
    String payment;
    String orderState;
    String currLoc;

    public Package(String orderid, String imgPath, String itemTitle, String itemCategory, String itemId, int itemNums, String payment, String orderState, String currLoc) {
        this.orderid = orderid;
        this.imgPath = imgPath;
        this.itemTitle = itemTitle;
        this.itemCategory = itemCategory;
        this.itemId = itemId;
        this.itemNums = itemNums;
        this.payment = payment;
        this.orderState = orderState;
        this.currLoc = currLoc;
    }

    public Package() {
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getItemNums() {
        return itemNums;
    }

    public void setItemNums(int itemNums) {
        this.itemNums = itemNums;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getCurrLoc() {
        return currLoc;
    }

    public void setCurrLoc(String currLoc) {
        this.currLoc = currLoc;
    }
}
