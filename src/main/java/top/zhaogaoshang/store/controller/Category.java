package top.zhaogaoshang.store.controller;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.zhaogaoshang.store.common.Utils;
import top.zhaogaoshang.store.mapper.OneCategoryMapper;
import top.zhaogaoshang.store.mapper.ProductMapper;
import top.zhaogaoshang.store.mapper.TwoCategoryMapper;
import top.zhaogaoshang.store.model.OneCategory;
import top.zhaogaoshang.store.model.Paging;
import top.zhaogaoshang.store.model.Result;
import top.zhaogaoshang.store.model.TwoCategory;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * 赵高尚
 * 2020/10/4 0004
 */
@CrossOrigin
@RestController
@RequestMapping("category")
public class Category {

    @Resource
    OneCategoryMapper oneCategoryMapper;

    @Resource
    TwoCategoryMapper twoCategoryMapper;

    @Resource
    Result result;

    @Resource
    Utils utils;

    @Resource
    OneCategory oneCategory;

    @Resource
    TwoCategory twoCategory;

    @Resource
    Paging paging;

    @Resource
    ProductMapper productMapper;

    /*
     * 更改分类
     * */
    @PostMapping("/edit")
    public Object putCategory(HttpServletRequest httpServletRequest) {
        Object type =  httpServletRequest.getParameter("type");
        HashMap map = new HashMap();
        System.out.println("获取的结果为 " + type);

        // 一级分类
        if ("1".equals(type)) {
            map.put("oneCategoryId",httpServletRequest.getParameter("oneCategoryId"));
            map.put("oneCategoryName",httpServletRequest.getParameter("editCategoryParamsName"));
            return this.updataOneCategory(map);
        } else {
            // 二级分类
            map.put("twoCategoryId",httpServletRequest.getParameter("twoCategoryId"));
            map.put("twoCategoryName",httpServletRequest.getParameter("editCategoryParamsName"));
            return this.twoCategoryUpdata(map);
        }
    }

    /*
     * 一级分类
     * 分类的添加
     * */
    @PostMapping("/one/add")
    public Object addOneCategory(OneCategory oneCategory) {
        oneCategory.setOneCategoryId(utils.uuid());
        int i = oneCategoryMapper.insertSelective(oneCategory);
        if (i == 1) {
            result.success("添加成功");
        } else {
            result.error("添加失败");
        }
        return result;
    }

    /*
     * 删除一级分类
     * */
    @DeleteMapping("/one/delete")
    public Object deleteOneCategory(String categoryId) {
        // 权限
//        if (userType != 1) {
//            result.error("您权限不足,请使用仓库创建");
//            return result;
//        }

        // 一级分类下是不是有二级分类
        ArrayList<TwoCategory> twoCategories = twoCategoryMapper.selectByOneCategoryId(categoryId, 1); // 删除一级分类
        if (!twoCategories.isEmpty()) {
            result.error("在此分类下有二级分类，请先删除二级分类");
            return result;
        }

        int i = oneCategoryMapper.deleteByCategoryId(categoryId);
        if (i == 1) {
            result.success("删除成功");
        } else {
            result.error("没有您要删除的分类");
        }
        return result;
    }

    /*
     * 更改一级分类名字
     * */
    @PostMapping("/one/updata")
    public Object updataOneCategory(HashMap map) {
        // 权限
//        String userType = httpServletRequest.getParameter("userType");
//        if (!"1".equals(userType)) {
//            result.error("权限不够");
//            return result;
//        }

        oneCategory.setOneCategoryId((String) map.get("oneCategoryId"));
        oneCategory.setOneCategoryName((String) map.get("editCategoryParamsName"));
        int i = oneCategoryMapper.updateByPrimaryKeySelective(oneCategory);

        if (i == 1) {
            result.success("更改成功");
        } else {
            result.error("更改失败");
        }

        return result;
    }

    /*
     * 查找一级分类列表
     * */
    @GetMapping("/one/list")
    public Object getOneCategory(String storeId, Integer page) {

        Integer count = oneCategoryMapper.selectCountByStoreId(storeId);// 数量
        System.out.println(count);
        ArrayList<OneCategory> oneCategories = oneCategoryMapper.selectByPrimaryId(storeId, page); // 查找结果

        paging.result(count, oneCategories, page);
        result.success(paging);
        return result;
    }

    /*
     * 二级分类的添加
     * */
    @PostMapping("/two/add")
    public Object twoOneCategory(TwoCategory twoCategory) {
        twoCategory.setTwoCategoryId(utils.uuid());
        int i = twoCategoryMapper.insertSelective(twoCategory);
        if (i == 1) {
            result.success("添加成功");
        } else {
            result.error("添加失败");
        }
        return result;
    }

    /*
     * 删除二级分类
     * */
    @DeleteMapping("/two/delete")
    public Object twoCategoreDelete(TwoCategory twoCategory) {

        Integer integer = productMapper.selectAllByCategory(twoCategory.getTwoCategoryId()); // 是否有商品
        System.out.println("二级分类下的商品数量：" + integer);
        if (integer > 0) {
            result.error("二级分类下有商品，请先清空商品");
            return result;
        }

        int i = twoCategoryMapper.deleteByPrimaryId(twoCategory.getTwoCategoryId());
        if (i == 1) {
            result.success("删除成功");
        } else {
            result.error("删除失败");
        }
        return result;
    }

    /*
     * 更改二级分类
     * */
    @PutMapping("two/updata")
    public Object twoCategoryUpdata(HashMap map) {

        twoCategory.setTwoCategoryId((String) map.get("twoCategoryId"));
        twoCategory.setTwoCategoryName((String) map.get("editCategoryParamsName"));

        int i = twoCategoryMapper.updateByPrimaryIdSelective(twoCategory);
        if (i == 1) {
            result.success("更改成功");
        } else {
            result.error("更改失败");
        }
        return result;
    }

    /*
     * 根据一级分类查找二级分类
     * */
    @GetMapping("/two/by/category/list")
    public Object twoCategoryByList(String oneCategoryId, Integer page) {
        Integer integer = twoCategoryMapper.selectByAllTwoCategory(oneCategoryId); // 所有二级分类
        System.out.println(integer);
        ArrayList<TwoCategory> twoCategories = twoCategoryMapper.selectByOneCategoryId(oneCategoryId, page);
        paging.result(integer, twoCategories, page);
        result.success(paging);
        return result;
    }

    /*
     * 根据仓库的id查找二级分类
     * */
    @GetMapping("/two/by/store/id")
    public Object twoByStoreId(String storeId) {
        ArrayList<TwoCategory> twoCategories = twoCategoryMapper.selectByStoreId(storeId);
        result.success(twoCategories);
        return result;
    }
}
