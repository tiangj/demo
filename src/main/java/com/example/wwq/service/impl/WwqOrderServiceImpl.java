package com.example.wwq.service.impl;

import com.example.wwq.entity.*;
import com.example.wwq.mapper.*;
import com.example.wwq.service.IWwqOrderService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
@Service
public class WwqOrderServiceImpl extends ServiceImpl<WwqOrderMapper, WwqOrder> implements IWwqOrderService {

    @Autowired
    private WwqCartMapper wwqCartMapper;


    @Autowired
    private WwqProductMapper wwqProductMapper;

    @Autowired
    private WwqOrderMapper wwqOrderMapper;

    @Autowired
    private WwqOrderDetailMapper wwqOrderDetailMapper;

    @Autowired
    private WwqProductFileMapper wwqProductFileMapper;

    @Autowired
    private WwqPayMapper wwqPayMapper;

    @Autowired
    private WwqAddressMapper wwqAddressMapper;

    @Override
    public List<Map<String, Object>> addShopCartProductCartPreOrder(String ids,String userId) {
        List<Map<String, Object>> retList  = new ArrayList<Map<String,Object>>();
        String[] shopCartIds = ids.split(",");
        for(int i = 0 ; i < shopCartIds.length ; i ++){
            //查询购物车信息
            WwqCart shopCart = wwqCartMapper.selectCartInfoByKey(shopCartIds[i]);
            if(shopCart == null){
                return null;
            }
            //查询商品信息
            WwqProduct wwqProduct = wwqProductMapper.selectProductInfoByKey(shopCart.getProductId());
            if(wwqProduct == null) {
                return null;
            }
            //查询商品logo
            WwqProductFile wwqProductFile = new WwqProductFile();
            wwqProductFile.setFileType(0);
            wwqProductFile.setProductId(wwqProduct.getId());
            WwqProductFile wwqProductFile1 = wwqProductFileMapper.selectOne(wwqProductFile);
            if(wwqProductFile1 == null) {
                return null;
            }
            System.out.println("商品总价跟购物车中的价格相同");
            //验证商品总价是否跟购物车中的价格相同
            BigDecimal totalPrice = wwqProduct.getProductNowPrice().multiply(new BigDecimal(shopCart.getBuyNum()));
            BigDecimal price =  wwqProduct.getProductNowPrice();
            if(totalPrice.compareTo(shopCart.getTotalPrice()) != 0){
                System.out.println("商品总价跟购物车中的价格不同！totalPrice："+totalPrice+"shopCart.getTotalPrice()"+shopCart.getTotalPrice());
                return null;
            }
            Map<String, Object> preOrder = new HashMap<>();
            preOrder.put("shopCartId", shopCartIds[i]);
            preOrder.put("shopCartNum", shopCart.getBuyNum());
            preOrder.put("filePath", wwqProductFile1.getFilePath());
            preOrder.put("productName", wwqProduct.getProductName());
            preOrder.put("totalPrice", price);
            preOrder.put("productType", wwqProduct.getProductType());
            retList.add(preOrder);
        }
        return retList;
    }


    @Override
    public Map<String, Object> addProductToOrder(String id,Integer buyNum,String userId) {
        //查询商品信息
        //查询商品信息
        WwqProduct wwqProduct = wwqProductMapper.selectProductInfoByKey(id);
        if(wwqProduct == null) {
            return null;
        }
        //查询商品logo
        WwqProductFile wwqProductFile = new WwqProductFile();
        wwqProductFile.setFileType(0);
        wwqProductFile.setProductId(wwqProduct.getId());
        WwqProductFile wwqProductFile1 = wwqProductFileMapper.selectOne(wwqProductFile);
        if(wwqProductFile1 == null) {
            return null;
        }
        //验证商品总价是否跟购物车中的价格相同
        BigDecimal totalPrice = wwqProduct.getProductNowPrice().multiply(new BigDecimal(buyNum));
        BigDecimal price =  wwqProduct.getProductNowPrice();
        Map<String, Object> preOrder = new HashMap<String, Object>();
        preOrder.put("productId", id);
        preOrder.put("buyNum", buyNum);
        preOrder.put("filePath", wwqProductFile1.getFilePath());
        preOrder.put("productName", wwqProduct.getProductName());
        preOrder.put("totalPrice", price);
        preOrder.put("productType", wwqProduct.getProductType());
        return preOrder;
    }


    @Override
    public PageInfo<Map<String, Object>> shopProductOrderList(String userId, Integer orderStatus, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Map<String,Object> example = new HashMap<String, Object>();
        example.put("interface", "shopPayList");
        example.put("payStatus", orderStatus);
        example.put("userId", userId);
        List<Map<String, Object>> list = wwqOrderMapper.shopPayList(example);
        if (list==null || list.size()<1) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            BigDecimal totalPostPrice = new BigDecimal(0);
            Map<String,Object> example1 = new HashMap<String, Object>();
            example1.put("orderStatus", list.get(i).get("pay_status").toString());
            example1.put("payId", list.get(i).get("id").toString());
            List<Map<String, Object>> lists = wwqOrderMapper.shopProductOrderList(example1);
            for(int j = 0; j < lists.size(); j++){
                totalPostPrice = totalPostPrice.add(new BigDecimal(lists.get(j).get("post_price").toString()));
            }
            list.get(i).put("preOrderList", lists);
            list.get(i).put("totalPostPrice", totalPostPrice);
        }
        PageInfo<Map<String,Object>> pageShopProductOrder = new PageInfo<Map<String,Object>>(list);
        return pageShopProductOrder;
    }

    /**
     * 根据订单状态查询订单数量
     */
    @Override
    public Map<String,Object> getStatusNumBystatus(String userId) {
        Map<String, Object> retMap = new HashMap<String, Object>();
        Map<String, Object> example = new HashMap<String, Object>();
        example.put("interface", "getStatusNumBystatus");
        example.put("orderStatus", 100);
        example.put("userId", userId);
        List<Map<String, Object>> status100 = wwqOrderMapper.getStatusNumBystatus(example);
        Map<String, Object> example1 = new HashMap<String, Object>();
        example1.put("orderStatus", 200);
        example1.put("userId", userId);
        List<Map<String, Object>> status200 = wwqOrderMapper.getStatusNumBystatus(example1);
        Map<String, Object> example2 = new HashMap<String, Object>();
        example2.put("orderStatus", 300);
        example2.put("userId", userId);
        List<Map<String, Object>> status300 = wwqOrderMapper.getStatusNumBystatus(example2);
        Map<String, Object> example3 = new HashMap<String, Object>();
        example3.put("orderStatus", 400);
        example3.put("userId", userId);
        List<Map<String, Object>> status400 = wwqOrderMapper.getStatusNumBystatus(example3);
        retMap.put("status100", status100);
        retMap.put("status200", status200);
        retMap.put("status300", status300);
        retMap.put("status400", status400);
        return retMap;
    }

    @Override
    public List<Map<String,Object>> shopProductOrderDetail(String userId,String orderId,Integer orderStatus) {
        Map<String,Object> example = new HashMap<String, Object>();
        example.put("interface", "shopPayInfo");
        example.put("payStatus", orderStatus);
        example.put("userId", userId);
        List<Map<String,Object>> shopPay = wwqOrderMapper.shopPayInfo(example);
        if (shopPay==null) {
            return null;
        }
        Map<String,Object> example1 = new HashMap<String, Object>();
        example1.put("payId", orderId);
        List<Map<String, Object>> lists = wwqOrderMapper.shopProductOrderListById(example1);
        if(lists == null || lists.size() < 1){
            return null;
        }
        //计算运费
        BigDecimal totalPostPrice = new BigDecimal(0);
        BigDecimal postPrice = new BigDecimal(0);
        for(int i = 0 ;i < lists.size(); i++){
            WwqProduct product = wwqProductMapper.selectById(lists.get(i).get("product_id").toString());
            if(product != null){
                postPrice = product.getPostPrice();
                totalPostPrice = totalPostPrice.add(postPrice);
            }
//            if(product.getPostPrice().compareTo(new BigDecimal(0)) == 0){
//                postPrice = new BigDecimal(0);
//            }else{
                postPrice = new BigDecimal(0);
//            }

        }
        shopPay.get(0).put("postPrice", postPrice);
        shopPay.get(0).put("orderList", lists);
        //判断是快递配送还是用户自提post_way_type
        if(Integer.parseInt(lists.get(0).get("post_way_type").toString()) != 100) {
            //获取用户默认收货地址
            shopPay.get(0).put("addressInfo", this.shopProdectAddressInfo(lists.get(0).get("id").toString()));
        }
        return shopPay;
    }

    public Map<String, Object> shopProdectAddressInfo(String orderId){
        Map<String,Object> example = new HashMap<String, Object>();
        example.put("orderId", orderId);
        List<Map<String,Object>> shopAddress = wwqAddressMapper.getUserAddressList(example);
        if(shopAddress == null || shopAddress.size()<1){
            return new HashMap<String, Object>();
        }else{
            return shopAddress.get(0);
        }
    }


    @Transactional
    @Override
    public List<Map<String, Object>> addShopProductCartOrder(String userId, String ids, Integer postWayType, String postDateId, Integer payWay, String remark, String addressId) {
        List<Map<String, Object>> shopOrderList = null;
        String[] shopCartIds = ids.split(",");
        for(int i = 0 ; i < shopCartIds.length ; i ++){
            //查询购物车信息
            WwqCart shopCart = wwqCartMapper.selectById(shopCartIds[i]);
            if(shopCart == null){
                return null;
            }
            //查询商品信息
            WwqProduct wwqProduct = wwqProductMapper.selectById(shopCart.getProductId());
            if(wwqProduct == null){
                return null;
            }
            //验证商品总价是否跟购物车中的价格相同
            BigDecimal totalPrice = wwqProduct.getProductNowPrice().multiply(new BigDecimal(shopCart.getBuyNum()));
            if(totalPrice.compareTo(shopCart.getTotalPrice()) != 0){
                return null;
            }
            //添加订单
            WwqOrder shopOrder = new WwqOrder();
            shopOrder.setOrderNum(shopCart.getBuyNum());
            shopOrder.setOrderTotalPrice(totalPrice);
            shopOrder.setOrderStatus(100);
            shopOrder.setPayStatus(100);
            shopOrder.setProductId(shopCart.getProductId());
            shopOrder.setProductTypeId(shopCart.getProductTypeId());
            shopOrder.setUserId(userId);
            shopOrder.setCreateDate(new Date());
            shopOrder.setCreateUser(userId);
            shopOrder.setUpdateDate(new Date());
            shopOrder.setUpdateUser(userId);
            shopOrder.setPayWay(payWay);
            shopOrder.setPostDateId(postDateId);
            shopOrder.setPostWayType(postWayType);
            shopOrder.setMessage(remark);
            if(postWayType == 1){
                shopOrder.setAddressId(addressId);
            }
            int ret = wwqOrderMapper.insert(shopOrder);
            if(ret < 1){
                new Exception();
                return null;
            }
            //新建商品轨迹记录
            WwqOrderDetail shopOrderDetail = new WwqOrderDetail();
            shopOrderDetail.setOrderId(shopOrder.getId());
            shopOrderDetail.setOrderStatus(100);
            shopOrderDetail.setCreateDate(new Date());
            shopOrderDetail.setCreateUser(userId);
            shopOrderDetail.setUpdateDate(new Date());
            shopOrderDetail.setUpdateUser(userId);
            int ret1 = wwqOrderDetailMapper.insert(shopOrderDetail);
            if(ret1 > 0){
                WwqCart record = new WwqCart();
                record.setId(shopCartIds[i]);
                record.setDeleteFlag(1);
                wwqCartMapper.updateById(record);
            }else{
                new Exception();
                return null;
            }
            Map<String, Object> preOrder = null;
            preOrder.put("orderId", shopOrder.getId());
            preOrder.put("product_id", shopOrder.getProductId());
            preOrder.put("orderPrice", shopOrder.getOrderTotalPrice());
            shopOrderList.add(preOrder);

        }
        return shopOrderList;
    }

    @Override
    public List<Map<String, Object>> addShopProductOrder(String userId, String id,Integer buyNum,Integer postWayType,String postDateId,Integer payWay,String remark,String addressId) {
        List<Map<String, Object>> shopOrderList = new ArrayList<>();
        //查询商品信息
        WwqProduct wwqProduct = wwqProductMapper.selectById(id);
        if(wwqProduct == null){
            return null;
        }
        //计算总价
        BigDecimal totalPrice = wwqProduct.getProductNowPrice().multiply(new BigDecimal(buyNum));
//		订单总价加上运费
//		totalPrice = totalPrice.add(new BigDecimal(shopProductList.get(0).get("post_price").toString()));
        //新建订单
        WwqOrder shopOrder = new WwqOrder();
        shopOrder.setOrderNum(buyNum);
        shopOrder.setOrderTotalPrice(totalPrice);
        shopOrder.setOrderStatus(100);
        shopOrder.setPayStatus(100);
        shopOrder.setProductId(id);
        shopOrder.setUserId(userId);
        shopOrder.setCreateDate(new Date());
        shopOrder.setCreateUser(userId);
        shopOrder.setUpdateDate(new Date());
        shopOrder.setUpdateUser(userId);
        shopOrder.setPayWay(payWay);
        shopOrder.setPostDateId(postDateId);
        shopOrder.setPostWayType(postWayType);
        shopOrder.setMessage(remark);
        if(postWayType == 1){
            shopOrder.setAddressId(addressId);
        }
        int ret = wwqOrderMapper.insert(shopOrder);
        if(ret < 1){
            return null;
        }
        //新建商品轨迹记录
        WwqOrderDetail shopOrderDetail = new WwqOrderDetail();
        shopOrderDetail.setOrderId(shopOrder.getId());
        shopOrderDetail.setOrderStatus(100);
        shopOrderDetail.setCreateDate(new Date());
        shopOrderDetail.setCreateUser(userId);
        shopOrderDetail.setUpdateDate(new Date());
        shopOrderDetail.setUpdateUser(userId);
        wwqOrderDetailMapper.insert(shopOrderDetail);
        Map<String, Object> preOrder = new HashMap<>();
        preOrder.put("orderId", shopOrder.getId());
        preOrder.put("product_id", shopOrder.getProductId());
        preOrder.put("orderPrice", shopOrder.getOrderTotalPrice());
        shopOrderList.add(preOrder);
        return shopOrderList;
    }


}
