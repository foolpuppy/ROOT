package top.wigon.entity;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/24 18:48
 **/
public class User {
    private String userId;
    private String userName;
    private String password;
    private String tel;
    private String email;
    private String avatarPath;
    private String roleType;
    private String createTime;

    public User() {
    }

    public User(String userId, String userName, String password, String tel, String email, String avatarPath, String roleType, String createTime) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.tel = tel;
        this.email = email;
        this.avatarPath = avatarPath;
        this.roleType = roleType;
        this.createTime = createTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", avatarPath='" + avatarPath + '\'' +
                ", roleType='" + roleType + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
