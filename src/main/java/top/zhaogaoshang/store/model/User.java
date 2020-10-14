package top.zhaogaoshang.store.model;

public class User {
    private Integer userIndex;

    private String userId;

    private String userName;

    private String userMobile;

    private Integer userSex;

    private String userPassword;

    private String userIdCard;

    private Integer userStatus;

    private Integer userType;

    private String storeId;

    public Integer getUserIndex() {
        return userIndex;
    }

    public void setUserIndex(Integer userIndex) {
        this.userIndex = userIndex;
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

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserIdCard() {
        return userIdCard;
    }

    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "User{" +
                "userIndex=" + userIndex +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", userSex=" + userSex +
                ", userPassword='" + userPassword + '\'' +
                ", userIdCard='" + userIdCard + '\'' +
                ", userStatus=" + userStatus +
                ", userType=" + userType +
                ", storeId='" + storeId + '\'' +
                '}';
    }
}