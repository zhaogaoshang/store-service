package top.zhaogaoshang.store.mapper;

import top.zhaogaoshang.store.model.Store;
import top.zhaogaoshang.store.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userIndex);

    int insert(User record);

    int insertSelective(User record);

    User selectUser(User user); // 查找用户

    int selectByMobile(String mobile); // 根据手机号码查找用户

    int updataByStoreId(Store store); // 更新或添加用户的仓库id

    User selectByPrimaryKey(Integer userIndex);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}