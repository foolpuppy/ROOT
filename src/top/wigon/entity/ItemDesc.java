package top.wigon.entity;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/24 21:58
 **/
public class ItemDesc {
    private int id;
    private String itemId;
    private String imagePath;
    private String desc;
    private String createTime;

    public ItemDesc() {
    }

    public ItemDesc(int id, String itemId, String imagePath, String desc, String createTime) {
        this.id = id;
        this.itemId = itemId;
        this.imagePath = imagePath;
        this.desc = desc;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
