package com.example.wwq.service;

import com.example.wwq.entity.WwqProduct;
import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * <p>
 * 商品主表 服务类
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
public interface IWwqProductService extends IService<WwqProduct> {


    PageInfo<Map<String,Object>> shopProductList(String sortId,Integer pageNum, Integer pageSize);

    PageInfo<Map<String,Object>> shopRecommended(Integer pageNum,Integer pageSize,Integer type);

    PageInfo<Map<String,Object>> searchShopProductList(String productName,Integer pageNum, Integer pageSize);

    Map<String, Object> shopProductListInfo(String id);
}
