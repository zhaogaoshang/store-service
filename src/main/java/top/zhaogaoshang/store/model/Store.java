package top.zhaogaoshang.store.model;

public class Store {
    private Integer storeIndex;

    private String storeId;

    private Integer storeStatus;

    private String userId;

    public Integer getStoreIndex() {
        return storeIndex;
    }

    public void setStoreIndex(Integer storeIndex) {
        this.storeIndex = storeIndex;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public Integer getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(Integer storeStatus) {
        this.storeStatus = storeStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}