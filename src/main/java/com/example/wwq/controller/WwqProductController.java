package com.example.wwq.controller;


import com.example.wwq.kit.JSONResult;
import com.example.wwq.service.IWwqProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * <p>
 * 商品主表 前端控制器
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
@Controller
@RequestMapping("/wwqProduct")
public class WwqProductController {

    @Autowired
    private IWwqProductService wwqProductService;


    /**
     *根据分类名查找商品列表
     * @param sortId 商品一级分类id
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/shopProductList",produces= "text/html;charset=UTF-8")
    @ResponseBody
    public String shopProductList(@RequestParam(value="productType",required=true) String sortId,
                                  @RequestParam(value="pageNum",defaultValue="1",required=true) Integer pageNum,
                                  @RequestParam(value="pageSize",defaultValue="10",required=true) Integer pageSize){
        PageInfo<Map<String,Object>> pageShopProduct = wwqProductService.shopProductList(sortId,pageNum, pageSize);
        return JSONResult.init(200, "success", pageShopProduct);
    }


    /**
     * 首页店选精品，战略品牌
     * @param type 查询类型（1:店选精品；2：战略品牌）
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/shopRecommended",produces= "text/html;charset=UTF-8")
    @ResponseBody
    public String shopRecommended(@RequestParam(value="type",required=true) Integer type,
                                  @RequestParam(value="pageNum",defaultValue="1",required=true) Integer pageNum,
                                  @RequestParam(value="pageSize",defaultValue="4",required=true) Integer pageSize){
        PageInfo<Map<String, Object>> newListingMap = wwqProductService.shopRecommended(pageNum, pageSize,type);
        return JSONResult.init(200, "success", newListingMap);

    }


    /**
     * 首页：根据商品名字搜索商品
     * @param productName 商品名称关键字
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/searchShopProductList",produces= "text/html;charset=UTF-8")
    @ResponseBody
    public String searchShopProductList(@RequestParam(value="key",required=false) String productName,
                                        @RequestParam(value="pageNum",defaultValue="1",required=true) Integer pageNum,
                                        @RequestParam(value="pageSize",defaultValue="10",required=true) Integer pageSize){
        PageInfo<Map<String,Object>> pageShopProduct = wwqProductService.searchShopProductList(productName,pageNum, pageSize);
        return JSONResult.init(200, "success", pageShopProduct);
    }


    /**
     *商品详情
     * @param id 商品ID
     * @return
     */
    @RequestMapping(value="/shopProductListInfo",produces= "text/html;charset=UTF-8")
    @ResponseBody
    public String shopProductListInfo(@RequestParam(value="productId",required=true) String id){
       Map<String, Object> shopProductDetail = wwqProductService.shopProductListInfo(id);
        return JSONResult.init(200, "success", shopProductDetail);
    }
}

