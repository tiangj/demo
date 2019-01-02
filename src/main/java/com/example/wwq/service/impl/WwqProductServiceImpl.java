package com.example.wwq.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.example.wwq.DO.ProductAddDO;
import com.example.wwq.DO.ProductDO;
import com.example.wwq.entity.WwqProduct;
import com.example.wwq.entity.WwqProductDetail;
import com.example.wwq.kit.FileHeadHelper;
import com.example.wwq.mapper.WwqProductDetailMapper;
import com.example.wwq.mapper.WwqProductFileMapper;
import com.example.wwq.mapper.WwqProductMapper;
import com.example.wwq.service.IWwqProductService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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

    @Autowired
    private WwqProductDetailMapper wwqProductDetailMapper;

    @Override
    public PageInfo<Map<String,Object>> shopProductList(String sortId, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        Map<String, Object> example = new HashMap<>();
        example.put("sortId", sortId);
        List<Map<String,Object>> list = wwqProductMapper.shopProductList(example);
        PageInfo<Map<String,Object>> pageShopProduct = new PageInfo<Map<String,Object>>(list);
        return pageShopProduct;
    }

    @Override
    public PageInfo<Map<String, Object>> shopRecommended(Integer pageNum, Integer pageSize,Integer type) {
        PageHelper.startPage(pageNum, pageSize);
        Map<String, Object> example = new HashMap<String, Object>();
        example.put("type", type);
        List<Map<String, Object>>  listing = wwqProductMapper.shopRecommended(example);
        PageInfo<Map<String,Object>> pageShopProduct = new PageInfo<Map<String,Object>>(listing);
        return pageShopProduct;
    }

    @Override
    public PageInfo<Map<String,Object>> searchShopProductList(String productName,Integer pageNum, Integer pageSize){PageHelper.startPage(pageNum, pageSize);
        Map<String, Object> example = new HashMap<String, Object>();
        example.put("productName", productName);
        List<Map<String,Object>> list = wwqProductMapper.searchShopProductList(example);
        PageInfo<Map<String,Object>> pageShopProduct = new PageInfo<Map<String,Object>>(list);
        return pageShopProduct;
    }


    @Override
    public Map<String, Object> shopProductListInfo(String id) {
        Map<String, Object> example = new HashMap<String, Object>();
        example.put("id", id);
        Map<String, Object> shopProductInfo = wwqProductMapper.shopProductListInfo(example);
        if(shopProductInfo != null && shopProductInfo.size() > 0){
            Map<String, Object> example1 = new HashMap<String, Object>();
            example1.put("id", shopProductInfo.get("id"));
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

    @Override
    public ProductAddDO getProductById(String id) {
        return wwqProductMapper.getProductById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> saveProduct(ProductAddDO productAddDO,String userId,String userName) throws Exception {
        Map<String,Object> result=new HashMap<>();
        try {
            //商品主表save
            WwqProduct wwqProduct=new WwqProduct();
            wwqProduct.setProductName(productAddDO.getProductName());
            wwqProduct.setProductOrginPrice(productAddDO.getProductOrginPrice());
            wwqProduct.setProductNowPrice(productAddDO.getProductNowPrice());
            wwqProduct.setProductNum(productAddDO.getProductNum());
            wwqProduct.setPostPrice(productAddDO.getPostPrice());
            wwqProduct.setRecommendBrand(productAddDO.getRecommendBrand());
            wwqProduct.setSellNum(productAddDO.getSellNum());
            wwqProduct.setRemainNum(productAddDO.getRemainNum());
            wwqProduct.setProductDec(productAddDO.getProductDec());
            wwqProduct.setSort(productAddDO.getSort());
            wwqProduct.setSortId(productAddDO.getSortId());
            wwqProduct.setRemark(productAddDO.getRemark());
            wwqProduct.setUpdateDate(new Date());
            wwqProduct.setUpdateUser(userId);
            wwqProduct.setProductType(productAddDO.getProductType());
            if(productAddDO.getId()==null || "".equals(productAddDO.getId())){
                wwqProduct.setCreateDate(new Date());
                wwqProduct.setCreateUser(userId);
                wwqProductMapper.insert(wwqProduct);
            }else{
                wwqProduct.setId(productAddDO.getId());
                wwqProductMapper.updateById(wwqProduct);
            }
            //商品详情表保持
            WwqProductDetail wwqProductDetail=new WwqProductDetail();
            wwqProductDetail.setShopProductId(wwqProduct.getId());
            wwqProductDetail.setPostWayId(productAddDO.getPostWayId()+"");
            wwqProductDetail.setUpdateDate(new Date());
            wwqProductDetail.setUpdataUser(userId);
            if(productAddDO.getDetailId()==null || "".equals(productAddDO.getDetailId())){
                wwqProductDetail.setCreateDate(new Date());
                wwqProductDetail.setCreateUser(userId);
                wwqProductDetailMapper.insert(wwqProductDetail);
            }else{
                wwqProductDetail.setId(productAddDO.getDetailId()+"");
                wwqProductDetailMapper.updateById(wwqProductDetail);
            }
            result.put("code",1);
            result.put("msg","操作成功");
        }catch (Exception e){
            e.printStackTrace();
            result.put("code",1);
            result.put("msg","操作失败");
            throw new Exception();
        }
        return result;
    }
}
