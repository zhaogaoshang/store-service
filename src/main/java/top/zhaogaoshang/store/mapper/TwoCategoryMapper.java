package top.zhaogaoshang.store.mapper;

import top.zhaogaoshang.store.model.TwoCategory;

import java.util.ArrayList;

public interface TwoCategoryMapper {
    int deleteByPrimaryId(String twoCategoryId);

    int insert(TwoCategory record);

    int insertSelective(TwoCategory record);

    ArrayList<TwoCategory> selectByOneCategoryId(String oneCategoryId); // 根据一级分类查找二级分类

    ArrayList<TwoCategory> selectByStoreId(String storeId); // 根据仓库id查找二级分类

    int updateByPrimaryIdSelective(TwoCategory record);

    int updateByPrimaryKey(TwoCategory record);
}