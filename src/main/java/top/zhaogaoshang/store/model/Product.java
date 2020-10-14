package top.zhaogaoshang.store.model;

public class Product {
    private Integer productIndex;

    private String productId;

    private String productName;

    private Integer productCount;

    private Integer productStatus;

    private String twoCategoryId;

    private String oneCategoryId;

    private String storeId;

    public Integer getProductIndex() {
        return productIndex;
    }

    public void setProductIndex(Integer productIndex) {
        this.productIndex = productIndex;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getTwoCategoryId() {
        return twoCategoryId;
    }

    public void setTwoCategoryId(String twoCategoryId) {
        this.twoCategoryId = twoCategoryId;
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
}