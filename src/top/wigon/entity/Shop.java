package top.wigon.entity;

import java.io.Serializable;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/24 21:28
 **/
public class Shop implements Serializable {
    private String shopId;
    private String userId;
    private String shopName;
    private String createTime;

    public Shop() {
    }

    public Shop(String shopId, String userId, String shopName, String createTime) {
        this.shopId = shopId;
        this.userId = userId;
        this.shopName = shopName;
        this.createTime = createTime;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
