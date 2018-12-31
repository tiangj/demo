package com.example.wwq.service.impl;

import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.example.wwq.entity.WwqCart;
import com.example.wwq.entity.WwqMember;
import com.example.wwq.entity.WwqProduct;
import com.example.wwq.kit.FileHeadHelper;
import com.example.wwq.mapper.WwqCartMapper;
import com.example.wwq.mapper.WwqMemberMapper;
import com.example.wwq.mapper.WwqProductMapper;
import com.example.wwq.service.IWwqCartService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * 购物车 服务实现类
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
@Service
public class WwqCartServiceImpl extends ServiceImpl<WwqCartMapper, WwqCart> implements IWwqCartService {

    @Autowired
    private WwqCartMapper wwqCartMapper;

    @Autowired
    private WwqMemberMapper wwqMemberMapper;

    @Autowired
    private WwqProductMapper wwqProductMapper;

    @Override
    public int addShopCart(String productId, Integer buyNum,String userId) {
        //查询商品信息
       WwqProduct shopProduct = wwqProductMapper.selectProductInfoByKey(productId);
        if(shopProduct == null){
            return 0;
        }
        // 查询会员情况
        WwqMember wwqMember = wwqMemberMapper.selectProductInfoByUserKey(userId);
        BigDecimal totalPrice;
        if(wwqMember == null){
            //非会员计算总价
            totalPrice = shopProduct.getProductOrginPrice().multiply(new BigDecimal(buyNum));
        }else {
            //会员计算总价
           totalPrice = shopProduct.getProductNowPrice().multiply(new BigDecimal(buyNum));
        }
        //查询购物车中是否存在当前商品
        Map<String, Object> example = new HashMap<>();
        example.put("productId", productId);
        example.put("userId", userId);
        List<Map<String, Object>> list = wwqCartMapper.selectCartByproductIdAndTypeIdUserId(example);
        System.out.println("list------->"+list);
        if(list == null || list.size() < 1){
            WwqCart shopCart = new WwqCart();
            shopCart.setBuyNum(buyNum);
            shopCart.setProductId(productId);
            shopCart.setUserId(userId);
            shopCart.setTotalPrice(totalPrice);
            shopCart.setCreateDate(new Date());
            shopCart.setUpdateDate(new Date());
            shopCart.setCreateUser(userId);
            shopCart.setUpdateUser(userId);
            int ret = wwqCartMapper.insertShopCartRecord(shopCart);
            return ret;
        }else{
            WwqCart shopCart = new WwqCart();
            shopCart.setBuyNum(Integer.parseInt(list.get(0).get("buy_num").toString())+buyNum);
            shopCart.setTotalPrice(new BigDecimal(list.get(0).get("total_price").toString()).add(totalPrice));
            shopCart.setId(list.get(0).get("id").toString());
            int ret = wwqCartMapper.updateShopCartRecordById(shopCart);
            return ret;
        }
    }

    @Override
    public Map<String, Object> shopProductCartList(String userId,Integer pageNum,Integer pageSize) {
        Map<String, Object> retMap = new HashMap<>();
        PageHelper.startPage(pageNum, pageSize);
        Map<String,Object> example = new HashMap<>();
        example.put("userId", userId);
        example.put("fileHead", FileHeadHelper.FILE_HEAD);
        List<Map<String, Object>> shopCartList = wwqCartMapper.shopProductCartList(example);
        PageInfo<Map<String,Object>> pageShopCart = new PageInfo<>(shopCartList);
        retMap.put("pageShopCart", pageShopCart);
        retMap.put("num", shopCartList.size());
        return retMap;
    }


    @Override
    public int modifyShopCartProductNum(String shopCartId,Integer num,String userId) {
        //查询购物车信息
        WwqCart shopCart = wwqCartMapper.selectCartInfoByKey(shopCartId);
        if(shopCart == null){
            return 500;
        }
        //查询商品信息
        WwqProduct shopProduct = wwqProductMapper.selectProductInfoByKey(shopCart.getProductId());
        if(shopProduct == null){
            return 500;
        }
        // 查询会员情况
        WwqMember wwqMember = wwqMemberMapper.selectProductInfoByUserKey(userId);
        BigDecimal totalPrice;
        if(wwqMember == null){
            //非会员计算总价
            totalPrice = shopProduct.getProductOrginPrice().multiply(new BigDecimal(num));
        }else {
            //会员计算总价
            totalPrice = shopProduct.getProductNowPrice().multiply(new BigDecimal(num));
        }
        //判断修改数量是否符合要求
        WwqCart shopCart2 = new WwqCart();
        shopCart2.setBuyNum(num);
        shopCart2.setId(shopCartId);
        shopCart2.setTotalPrice(totalPrice);
        int ret = wwqCartMapper.updateShopCartRecordById(shopCart2);
        return ret;
    }

    @Override
    public int deleteShopCartProduct(String shopCartId) {
        WwqCart shopCart = new WwqCart();
        shopCart.setId(shopCartId);
        shopCart.setDeleteFlag(1);
        return wwqCartMapper.updateShopCartRecordById(shopCart);
    }


    @Override
    public Integer shopCartProductNum(String userId) {
        Map<String, Object> example = new HashMap<>();
        example.put("userId", userId);
        Integer ret = wwqCartMapper.shopCartProductNum(example);
        return ret;
    }
}
