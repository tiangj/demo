package com.example.wwq.mapper;


import com.baomidou.mybatisplus.plugins.Page;
import com.example.wwq.DO.ProductAddDO;
import com.example.wwq.DO.ProductDO;
import com.example.wwq.entity.WwqProduct;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品主表 Mapper 接口
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
public interface WwqProductMapper extends BaseMapper<WwqProduct> {


    List<Map<String,Object>> shopProductList(Map<String,Object> map);

    List<Map<String,Object>> shopRecommended(Map<String,Object> map);

    List<Map<String,Object>> searchShopProductList(Map<String,Object> map);

    Map<String,Object> shopProductListInfo(Map<String,Object> map);

    WwqProduct selectProductInfoByKey(String id);

    ProductAddDO getProductById(String id);

    List<ProductDO> getAllProduct(Page<ProductDO> page, ProductDO productDO);
}
