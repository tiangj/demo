package com.example.wwq.service;

import com.example.wwq.entity.WwqCart;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 购物车 服务类
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
public interface IWwqCartService extends IService<WwqCart> {


    int addShopCart(String productId,Integer buyNum,String userId);

    Map<String, Object> shopProductCartList(String userId, Integer pageNum, Integer pageSize);

    int modifyShopCartProductNum(String shopCartId,Integer num,String userId);

    int deleteShopCartProduct(String shopCartId);

    Integer shopCartProductNum(String userId);
}
