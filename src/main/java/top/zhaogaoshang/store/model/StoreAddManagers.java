package top.zhaogaoshang.store.model;

/**
 * 赵高尚
 * 2020/10/4 0004
 */
public class StoreAddManagers {
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

    private User user;


    public Integer getUserIndex() {
        return userIndex;
    }

    public StoreAddManagers setUserIndex(Integer userIndex) {
        this.userIndex = userIndex;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public StoreAddManagers setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public StoreAddManagers setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public StoreAddManagers setUserMobile(String userMobile) {
        this.userMobile = userMobile;
        return this;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public StoreAddManagers setUserSex(Integer userSex) {
        this.userSex = userSex;
        return this;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public StoreAddManagers setUserPassword(String userPassword) {
        this.userPassword = userPassword;
        return this;
    }

    public String getUserIdCard() {
        return userIdCard;
    }

    public StoreAddManagers setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard;
        return this;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public StoreAddManagers setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
        return this;
    }

    public Integer getUserType() {
        return userType;
    }

    public StoreAddManagers setUserType(Integer userType) {
        this.userType = userType;
        return this;
    }

    public String getStoreId() {
        return storeId;
    }

    public StoreAddManagers setStoreId(String storeId) {
        this.storeId = storeId;
        return this;
    }

    public User getUser() {
        return user;
    }

    public StoreAddManagers setUser(User user) {
        this.user = user;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
