package top.zhaogaoshang.store.mapper;

import top.zhaogaoshang.store.model.Store;

public interface StoreMapper {
    int deleteByPrimaryKey(Integer storeIndex);

    int insert(Store record);

    int insertSelective(Store record);

    int selectByUserId(String userId); // 根据用户id查找仓库

    Store selectStoreByStoreId(String storeId); // 根据仓库的id查找仓库

    Store selectByPrimaryKey(Integer storeIndex);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);
}