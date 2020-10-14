package top.zhaogaoshang.store.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import top.zhaogaoshang.store.common.Utils;
import top.zhaogaoshang.store.mapper.StoreMapper;
import top.zhaogaoshang.store.mapper.UserMapper;
import top.zhaogaoshang.store.model.Result;
import top.zhaogaoshang.store.model.StoreAddManagers;
import top.zhaogaoshang.store.model.User;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 赵高尚
 * 2020/10/2 0002
 */
@RestController
public class Store {

    @Resource
    StoreMapper storeMapper;

    @Resource
    UserMapper userMapper;

    @Resource
    Result result;

    @Resource
    Utils utils;

    /*
    添加管理人员
    这里的userId为仓库超级管理员的id
    这里的storeId为仓库超级管理员所在的仓库id
    其他信息为
    */
    @PostMapping("/store/add/managers")
    public Object addManagers(HttpServletRequest httpServletRequest) {
        String userType = httpServletRequest.getParameter("userType");
        if ("1".equals(userType)) {
            Object addUser1 = JSONObject.parse(httpServletRequest.getParameter("addUser"));
            User addUser = JSON.parseObject(addUser1.toString(), User.class);
            addUser.setUserId(utils.uuid());
            addUser.setStoreId(httpServletRequest.getParameter("storeId"));

            int i = userMapper.insertSelective(addUser);
            if (i == 1) {
                result.success("成功");
            } else {
                result.error("添加人员失败");
            }
            return result;
        } else {
            result.error("权限不足");
            return result;
        }

    }

    // 创建仓库
    @PostMapping("/store/create")
    public Object createStore(top.zhaogaoshang.store.model.Store store) {

        Integer integer = this.searchIsHaveStore(store.getUserId());
        if (integer > 0) {
            result.error("此号码已经已经创建过仓库");
            return result;
        } else {
            store.setStoreId(utils.uuid());
            int insert = storeMapper.insertSelective(store);
            if (insert == 1) {
                result.success(store);
                return result;
            } else {
                result.error("创建仓库-系统繁忙");
                return result;
            }
        }
    }


    // 申请仓库
    @PostMapping("/apply_for")
    public Object applyFor() {
//        Integer integer1 = storeMapper.selectCount();

//        storeMapper.insert();

        return 123;
    }

    // 根据仓库id查找仓库
    public Object searchStoreByStoreId(String storeId) {
        return storeMapper.selectStoreByStoreId(storeId);
    }

    // 查找用户是否创建过仓库
    public Integer searchIsHaveStore(String userId) {
        return storeMapper.selectByUserId(userId);
    }
}
