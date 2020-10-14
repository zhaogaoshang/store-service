package top.zhaogaoshang.store.model;

import org.springframework.stereotype.Component;

@Component
public class OneCategory {
    private Integer oneCategoryIndex;

    private String oneCategoryId;

    private String oneCategoryName;

    private String storeId;

    public Integer getOneCategoryIndex() {
        return oneCategoryIndex;
    }

    public void setOneCategoryIndex(Integer oneCategoryIndex) {
        this.oneCategoryIndex = oneCategoryIndex;
    }

    public String getOneCategoryId() {
        return oneCategoryId;
    }

    public void setOneCategoryId(String oneCategoryId) {
        this.oneCategoryId = oneCategoryId;
    }

    public String getOneCategoryName() {
        return oneCategoryName;
    }

    public void setOneCategoryName(String oneCategoryName) {
        this.oneCategoryName = oneCategoryName;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }
}