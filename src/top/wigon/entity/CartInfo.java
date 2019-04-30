package top.wigon.entity;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/30 13:42
 **/
public class CartInfo {
    private int num;
    private String itemId;

    public CartInfo(String itemId, int num) {
        this.num = num;
        this.itemId = itemId;
    }

    public CartInfo() {
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
