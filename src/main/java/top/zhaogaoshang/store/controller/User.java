package top.zhaogaoshang.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.zhaogaoshang.store.common.Utils;
import top.zhaogaoshang.store.mapper.UserMapper;
import top.zhaogaoshang.store.model.Result;
import top.zhaogaoshang.store.model.Store;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 赵高尚
 * 2020/10/2 0002
 */
@CrossOrigin
@RestController
@RequestMapping("user")
@Controller
public class User {

    @Resource
    UserMapper userMapper;

    @Resource
    Result result;

    @Resource
    Utils utils;

    @Resource
    top.zhaogaoshang.store.controller.Store storeController;

    @PostMapping("/user")
    public Object inset() {
        return 123;
    }

    // 根据用户名和密码搜索用户
    @GetMapping("/search")
    public Object search(top.zhaogaoshang.store.model.User user) {
        top.zhaogaoshang.store.model.User user1 = userMapper.selectUser(user);
        System.out.println(user1);
        // 查找不到用户
        if (user1 == null) {
            result.success(new HashMap<>());
        } else {
            result.success(user1);
        }
        return result;
    }

    /*
     * 用户登录
     *
     * */
    @PostMapping("/login")
    public Object login(top.zhaogaoshang.store.model.User user) {

        try {
            top.zhaogaoshang.store.model.User user1 = userMapper.selectUser(user);
            // 查找不到用户
            if (user1 == null) {
                result.error("用户名或密码错误");
            } else {
                result.success(user1);
            }
        } catch (Exception e) {
            result.error("服务器忙");
        }

        return result;
    }

    /**
     * 用户主注册
     * private Integer userIndex;
     * <p>
     * private String userId;
     * <p>
     * private String userName;
     * <p>
     * private String userMobile;
     * <p>
     * private Integer userSex;
     * <p>
     * private String userPassword;
     * <p>
     * private String userIdCard;
     * <p>
     * private Integer userStatus;
     * <p>
     * private String storeId;
     */

    @PostMapping("/registered")
    public Object registered(top.zhaogaoshang.store.model.User user) {
//        参数是否存在
        if (user.getUserName() == null || user.getUserMobile() == null || user.getUserPassword() == null) {
            result.error("参数缺失1");
            return result;
        }
        if ("".equals(user.getUserName()) || "".equals(user.getUserMobile()) || "".equals(user.getUserPassword())) {
            result.error("参数缺失2");
            return result;
        }

        // 手机号码是否存在
        Integer mobileNumber = this.searchIsHaveMobile(user.getUserMobile());
        System.out.println(mobileNumber);
        if (mobileNumber > 0) {
            result.error("手机号码已经存在");
        } else {
            user.setUserId(utils.uuid());
            user.setUserType(1);
            int i = userMapper.insertSelective(user);
            result.success("成功");
        }
        return result;
    }

    // 用户更改或者加入仓库
    @PostMapping("/join/store")
    public Object joinStore(top.zhaogaoshang.store.model.Store store) {

        Object o = storeController.searchStoreByStoreId(store.getStoreId());
        System.out.println(o);

        if (o == null) {
            result.error("没有您要加入的仓库");
        } else {
            int i = userMapper.updataByStoreId(store);
            if (i == 0) {
                result.error("更改-系统繁忙");
            } else {
                result.success("成功");
            }
        }
        return result;
    }


    // 根据用户手机号码查找用户是否存在
    public Integer searchIsHaveMobile(String mobile) {
        return userMapper.selectByMobile(mobile);
    }

    //
}
