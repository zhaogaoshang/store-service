package top.zhaogaoshang.store.model;

import org.springframework.stereotype.Component;

@Component
public class TwoCategory {
    private Integer twoCategoryIndex;

    private String twoCategoryId;

    private String twoCategoryName;

    private String oneCategoryId;

    private String storeId;

    public Integer getTwoCategoryIndex() {
        return twoCategoryIndex;
    }

    public void setTwoCategoryIndex(Integer twoCategoryIndex) {
        this.twoCategoryIndex = twoCategoryIndex;
    }

    public String getTwoCategoryId() {
        return twoCategoryId;
    }

    public void setTwoCategoryId(String twoCategoryId) {
        this.twoCategoryId = twoCategoryId;
    }

    public String getTwoCategoryName() {
        return twoCategoryName;
    }

    public void setTwoCategoryName(String twoCategoryName) {
        this.twoCategoryName = twoCategoryName;
    }

    public String getOneCategoryId() {
        return oneCategoryId;
    }

    public void setOneCategoryId(String oneCategoryId) {
        this.oneCategoryId = oneCategoryId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    @Override
    public String toString() {
        return "TwoCategory{" +
                "twoCategoryIndex=" + twoCategoryIndex +
                ", twoCategoryId='" + twoCategoryId + '\'' +
                ", twoCategoryName='" + twoCategoryName + '\'' +
                ", oneCategoryId='" + oneCategoryId + '\'' +
                ", storeId='" + storeId + '\'' +
                '}';
    }
}