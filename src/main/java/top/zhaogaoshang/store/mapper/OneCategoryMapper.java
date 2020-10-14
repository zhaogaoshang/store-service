package top.zhaogaoshang.store.mapper;

import top.zhaogaoshang.store.model.OneCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface OneCategoryMapper {
    int deleteByPrimaryKey(Integer oneCategoryIndex);

    int deleteByCategoryId(String categoryId); // 根据id删除

    int insert(OneCategory record);

    int insertSelective(OneCategory record);

    ArrayList<OneCategory> selectByPrimaryId(String storeId, Integer page);

    Integer selectCountByStoreId(String storeId); // 查找一级分类

    int updateByPrimaryKeySelective(OneCategory record);

    int updateByPrimaryKey(OneCategory record);
}