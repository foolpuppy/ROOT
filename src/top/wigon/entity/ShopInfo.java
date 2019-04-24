package top.wigon.entity;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/24 22:00
 **/
public class ShopInfo {
    private int id;
    private int shopId;
    private String Desc;
    private String logoPath;
    private String createTime;

    public ShopInfo() {
    }

    public ShopInfo(int id, int shopId, String desc, String logoPath, String createTime) {
        this.id = id;
        this.shopId = shopId;
        Desc = desc;
        this.logoPath = logoPath;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
