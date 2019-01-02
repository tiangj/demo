package com.example.wwq.service.impl;

import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.example.wwq.entity.WwqCart;
import com.example.wwq.entity.WwqMember;
import com.example.wwq.entity.WwqOrder;
import com.example.wwq.kit.FileHeadHelper;
import com.example.wwq.mapper.WwqCartMapper;
import com.example.wwq.mapper.WwqMemberMapper;
import com.example.wwq.mapper.WwqOrderMapper;
import com.example.wwq.mapper.WwqProductMapper;
import com.example.wwq.service.IWwqOrderService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//
//    @Autowired
//    private WwqOrderMapper wwqOrderMapper;
//
//    @Autowired
//    private WwqCartMapper wwqCartMapper;
//
//    @Autowired
//    private WwqProductMapper wwqProductMapper;
//
//    @Autowired
//    private WwqMemberMapper wwqMemberMapper;
//
//    @Override
//    public List<Map<String, Object>> addShopCartProductCartPreOrder(String ids,String userId) {
//        List<Map<String, Object>> retList  = new ArrayList<Map<String,Object>>();
//        String[] shopCartIds = ids.split(",");
//        for(int i = 0 ; i < shopCartIds.length ; i ++){
//            //查询购物车信息
//            WwqCart shopCart = wwqCartMapper.selectCartInfoByKey(shopCartIds[i]);
//            if(shopCart == null){
//                return null;
//            }
//            //查询商品信息
//            Map<String, Object> example = new HashMap<>();
//            example.put("id", shopCart.getProductId());
//            example.put("fileHead", FileHeadHelper.FILE_HEAD);
//            Map<String, Object> shopProductList = wwqProductMapper.shopProductListInfo(example);
//            if(shopProductList == null || shopProductList.size() < 1) {
//                return null;
//            }
//            System.out.println("商品总价跟购物车中的价格相同");
//            //验证商品总价是否跟购物车中的价格相同
//            // 查询会员情况
//            WwqMember wwqMember = wwqMemberMapper.selectProductInfoByUserKey(userId);
//            BigDecimal totalPrice;
//            BigDecimal price;
//            if(wwqMember == null){
//                //非会员计算总价
//                totalPrice = new BigDecimal(shopProductList.get("product_orgin_price").toString()).multiply(new BigDecimal(shopCart.getBuyNum()));
//                price =  new BigDecimal(shopProductList.get("product_orgin_price").toString());
//            }else {
//                //会员计算总价
//                totalPrice = new BigDecimal(shopProductList.get("product_now_price").toString()).multiply(new BigDecimal(shopCart.getBuyNum()));
//                price =  new BigDecimal(shopProductList.get("product_now_price").toString());
//            }
//            if(totalPrice.compareTo(shopCart.getTotalPrice()) != 0){
//                System.out.println("商品总价跟购物车中的价格不同！totalPrice："+totalPrice+"shopCart.getTotalPrice()"+shopCart.getTotalPrice());
//                return null;
//            }
//            Map<String, Object> preOrder = new HashMap<>();
//            preOrder.put("shopCartId", shopCartIds[i]);
//            preOrder.put("shopCartNum", shopCart.getBuyNum());
//            preOrder.put("filePath", shopProductList.get("file_path"));
//            preOrder.put("productName", shopProductList.get("product_name"));
//            preOrder.put("totalPrice", price);
//            preOrder.put("productType", shopProductList.get("product_type"));
//            retList.add(preOrder);
//        }
//        return retList;
//    }
//
//
//    @Override
//    public Map<String, Object> addProductToOrder(String id,Integer buyNum,String userId) {
//        //查询商品信息
//        Map<String, Object> example = new HashMap<>();
//        example.put("id", id);
//        example.put("fileHead", FileHeadHelper.FILE_HEAD);
//        Map<String, Object> shopProductList = wwqProductMapper.shopProductListInfo(example);
//        if(shopProductList == null || shopProductList.size() < 1) {
//            return null;
//        }
//        //验证商品总价是否跟购物车中的价格相同
//        // 查询会员情况
//        WwqMember wwqMember = wwqMemberMapper.selectProductInfoByUserKey(userId);
//        BigDecimal totalPrice;
//        BigDecimal price;
//        if(wwqMember == null){
//            //非会员计算总价
//            totalPrice = new BigDecimal(shopProductList.get("product_orgin_price").toString()).multiply(new BigDecimal(buyNum));
//            price =  new BigDecimal(shopProductList.get("product_orgin_price").toString());
//        }else {
//            //会员计算总价
//            totalPrice = new BigDecimal(shopProductList.get("product_now_price").toString()).multiply(new BigDecimal(buyNum));
//            price =  new BigDecimal(shopProductList.get("product_now_price").toString());
//        }
//        Map<String, Object> preOrder = new HashMap<String, Object>();
//        preOrder.put("productId", id);
//        preOrder.put("buyNum", buyNum);
//        preOrder.put("filePath", shopProductList.get("file_path"));
//        preOrder.put("productName", shopProductList.get("product_name"));
//        preOrder.put("totalPrice", price);
//        preOrder.put("productType", shopProductList.get("product_type"));
//        return preOrder;
//    }
//
//
//    @Override
//    public PageInfo<Map<String, Object>> shopProductOrderList(String userId, Integer orderStatus, Integer pageNum, Integer pageSize) {
//        PageHelper.startPage(pageNum, pageSize);
//        Map<String,Object> example = new HashMap<>();
//        example.put("payStatus", orderStatus);
//        example.put("userId", userId);
//        List<Map<String, Object>> list = wwqOrderMapper.shopPayList(example);
//        if (list==null || list.size()<1) {
//            return null;
//        }
//        for (int i = 0; i < list.size(); i++) {
//            BigDecimal totalPostPrice = new BigDecimal(0);
//            Map<String,Object> example1 = new HashMap<>();
//            example1.put("orderStatus", list.get(i).get("pay_status").toString());
//            example1.put("payId", list.get(i).get("id").toString());
//            example1.put("fileHead", FileHeadHelper.FILE_HEAD);
//            List<Map<String, Object>> lists = wwqOrderMapper.shopProductOrderList(example1);
//            for(int j = 0; j < lists.size(); j++){
//                totalPostPrice = totalPostPrice.add(new BigDecimal(lists.get(j).get("post_price").toString()));
//            }
//            list.get(i).put("preOrderList", lists);
//            list.get(i).put("totalPostPrice", totalPostPrice);
//        }
//        PageInfo<Map<String,Object>> pageShopProductOrder = new PageInfo<Map<String,Object>>(list);
//        return pageShopProductOrder;
//    }
//
//    /**
//     * 根据订单状态查询订单数量
//     */
//    @Override
//    public Map<String,Object> getStatusNumBystatus(String userId) {
//        Map<String, Object> retMap = new HashMap<String, Object>();
//        Map<String, Object> example = new HashMap<String, Object>();
//        example.put("interface", "getStatusNumBystatus");
//        example.put("orderStatus", 100);
//        example.put("userId", userId);
//        List<Map<String, Object>> status100 = wwqOrderMapper.getStatusNumBystatus(example);
//        Map<String, Object> example1 = new HashMap<String, Object>();
//        example1.put("orderStatus", 200);
//        example1.put("userId", userId);
//        List<Map<String, Object>> status200 = wwqOrderMapper.getStatusNumBystatus(example1);
//        Map<String, Object> example2 = new HashMap<String, Object>();
//        example2.put("orderStatus", 300);
//        example2.put("userId", userId);
//        List<Map<String, Object>> status300 = wwqOrderMapper.getStatusNumBystatus(example2);
//        Map<String, Object> example3 = new HashMap<String, Object>();
//        example3.put("orderStatus", 400);
//        example3.put("userId", userId);
//        List<Map<String, Object>> status400 = wwqOrderMapper.getStatusNumBystatus(example3);
//        Map<String, Object> example4 = new HashMap<String, Object>();
//        example4.put("orderStatus", 500);
//        example4.put("userId", userId);
//        List<Map<String, Object>> status500 = wwqOrderMapper.getStatusNumBystatus(example4);
//        Map<String, Object> example5 = new HashMap<String, Object>();
//        example5.put("orderStatus", 600);
//        example5.put("userId", userId);
//        List<Map<String, Object>> status600 = wwqOrderMapper.getStatusNumBystatus(example5);
//        retMap.put("status100", status100);
//        retMap.put("status200", status200);
//        retMap.put("status300", status300);
//        retMap.put("status400", status400);
//        retMap.put("status500", status500);
//        retMap.put("status600", status600);
//        return retMap;
//    }
}
