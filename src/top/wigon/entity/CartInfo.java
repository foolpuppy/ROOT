package top.wigon.entity;


import java.util.List;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/30 13:42
 **/
public class CartInfo {
    List<Item> items;
    private int num;
    private String itemId;

    public CartInfo(String itemId, int num, List<Item> items) {
        this.items = items;
        this.num = num;
        this.itemId = itemId;
    }

    public CartInfo() {
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}
