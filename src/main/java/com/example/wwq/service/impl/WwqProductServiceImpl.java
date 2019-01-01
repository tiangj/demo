package com.example.wwq.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.example.wwq.DO.ProductDO;
import com.example.wwq.entity.WwqProduct;
import com.example.wwq.kit.FileHeadHelper;
import com.example.wwq.mapper.WwqProductFileMapper;
import com.example.wwq.mapper.WwqProductMapper;
import com.example.wwq.service.IWwqProductService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品主表 服务实现类
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
@Service
public class WwqProductServiceImpl extends ServiceImpl<WwqProductMapper, WwqProduct> implements IWwqProductService {

    @Autowired
    private WwqProductMapper wwqProductMapper;

    @Autowired
    private WwqProductFileMapper wwqProductFileMapper;

    @Override
    public PageInfo<Map<String,Object>> shopProductList(String sortId, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        Map<String, Object> example = new HashMap<>();
        example.put("sortId", sortId);
        example.put("fileHead", FileHeadHelper.FILE_HEAD);
        List<Map<String,Object>> list = wwqProductMapper.shopProductList(example);
        PageInfo<Map<String,Object>> pageShopProduct = new PageInfo<Map<String,Object>>(list);
        return pageShopProduct;
    }

    @Override
    public PageInfo<Map<String, Object>> shopRecommended(Integer pageNum, Integer pageSize,Integer type) {
        PageHelper.startPage(pageNum, pageSize);
        Map<String, Object> example = new HashMap<String, Object>();
        example.put("type", type);
        example.put("fileHead", FileHeadHelper.FILE_HEAD);
        List<Map<String, Object>>  listing = wwqProductMapper.shopRecommended(example);
        PageInfo<Map<String,Object>> pageShopProduct = new PageInfo<Map<String,Object>>(listing);
        return pageShopProduct;
    }

    @Override
    public PageInfo<Map<String,Object>> searchShopProductList(String productName,Integer pageNum, Integer pageSize){PageHelper.startPage(pageNum, pageSize);
        Map<String, Object> example = new HashMap<String, Object>();
        example.put("productName", productName);
        example.put("fileHead", FileHeadHelper.FILE_HEAD);
        List<Map<String,Object>> list = wwqProductMapper.searchShopProductList(example);
        PageInfo<Map<String,Object>> pageShopProduct = new PageInfo<Map<String,Object>>(list);
        return pageShopProduct;
    }


    @Override
    public Map<String, Object> shopProductListInfo(String id) {
        Map<String, Object> example = new HashMap<String, Object>();
        example.put("fileHead", FileHeadHelper.FILE_HEAD);
        example.put("id", id);
        Map<String, Object> shopProductInfo = wwqProductMapper.shopProductListInfo(example);
        if(shopProductInfo != null && shopProductInfo.size() > 0){
            Map<String, Object> example1 = new HashMap<String, Object>();
            example1.put("id", shopProductInfo.get("id"));
            example1.put("fileHead", FileHeadHelper.FILE_HEAD);
            List<Map<String,Object>> productFileList = wwqProductFileMapper.selectProductFileListByProductId(example1);
            if(productFileList == null || productFileList.size() < 1){
                shopProductInfo.put("productFileList", new ArrayList<Map<String, Object>>());
            }else{
                shopProductInfo.put("productFileList", productFileList);
            }
        }
        return shopProductInfo;
    }

    @Override
    public Page<ProductDO> getAllProduct(Page<ProductDO> page, ProductDO productDO) {
        page.setRecords(wwqProductMapper.getAllProduct(page,productDO));
        return page;
    }
}
