package top.wigon.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/24 19:15
 **/
public class Item implements Serializable {
    String id;
    String title;
    String catefory;
    BigDecimal price;
    int stock;
    int state;
    int shopId;
    String createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCatefory() {
        return catefory;
    }

    public void setCatefory(String catefory) {
        this.catefory = catefory;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
