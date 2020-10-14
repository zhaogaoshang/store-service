package top.zhaogaoshang.store.controller;

import org.springframework.web.bind.annotation.*;
import top.zhaogaoshang.store.common.Utils;
import top.zhaogaoshang.store.mapper.ProductMapper;
import top.zhaogaoshang.store.model.Paging;
import top.zhaogaoshang.store.model.Result;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * 赵高尚
 * 2020/10/4 0004
 */
@CrossOrigin
@RestController
@RequestMapping("product")
public class Product {

    @Resource
    ProductMapper productMapper;

    @Resource
    Result result;

    @Resource
    Paging paging;

    @PostMapping("/add")
    public Object addProdect(top.zhaogaoshang.store.model.Product product) {
        product.setProductStatus(1);
        product.setProductId(Utils.uuid());
        int insert = productMapper.insert(product);
        if (insert == 1) {
            result.success("添加成功");
        } else {
            result.error("添加失败");
        }
        return result;
    }

    //    根据分类id查找商品 有分页
    @GetMapping("/select/by/category")
    public Object selectByCategory( String twoCategoryId,  Integer page) {
        System.out.println(twoCategoryId);
        System.out.println(page);
        Integer integer = productMapper.selectAllByCategory(twoCategoryId); // 总数
        ArrayList arrayList = productMapper.selectByCategory(twoCategoryId, page); // 查找的商品
        paging.result(integer, arrayList, page);
        result.success(paging);
        return result;
    }

}
