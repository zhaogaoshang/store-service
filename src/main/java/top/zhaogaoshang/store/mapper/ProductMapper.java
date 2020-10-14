package top.zhaogaoshang.store.mapper;

import top.zhaogaoshang.store.model.Product;

import java.util.ArrayList;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer productIndex);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productIndex);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    //    根据分类id查找商品
    ArrayList selectByCategory(String twoCategoryId, Integer page);

    // 分类下的所有商品数量
    Integer selectAllByCategory(String twoCategoryId);
}