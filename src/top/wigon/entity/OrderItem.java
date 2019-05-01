package top.wigon.entity;

import java.math.BigDecimal;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/24 22:11
 **/
public class OrderItem {
    private int id;
    private int itemId;
    private String orderId;
    private int num;
    private String title;
    private BigDecimal price;
    private BigDecimal totalFee;

    public OrderItem() {
    }

    public OrderItem(int id, int itemId, String orderId, int num, String title, BigDecimal price, BigDecimal totalFee) {
        this.id = id;
        this.itemId = itemId;
        this.orderId = orderId;
        this.num = num;
        this.title = title;
        this.price = price;
        this.totalFee = totalFee;
    }

    public int getId() {
        return id;
    }


    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalFee() {
        return price.multiply(BigDecimal.valueOf(num));
    }

}
