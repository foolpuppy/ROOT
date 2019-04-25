package top.wigon.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/24 19:15
 **/
public class Item implements Serializable {
    private String id;
    private String title;
    private String category;
    private BigDecimal price;
    private int stock;
    private int state;
    private int shopId;
    private String createTime;

    public Item() {
    }

    public Item(String id, String title, String category, BigDecimal price, int stock, int state, int shopId, String createTime) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.state = state;
        this.shopId = shopId;
        this.createTime = createTime;
    }

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", state=" + state +
                ", shopId=" + shopId +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
