package com.example.wwq.service;

import com.example.wwq.entity.WwqOrder;
import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
public interface IWwqOrderService extends IService<WwqOrder> {


    List<Map<String, Object>> addShopCartProductCartPreOrder(String ids,String userId);

    Map<String, Object> addProductToOrder(String id,Integer buyNum,String userId);

    PageInfo<Map<String,Object>> shopProductOrderList(String userId, Integer orderStatus, Integer pageNum, Integer pageSize);

    Map<String,Object> getStatusNumBystatus(String userId);

    List<Map<String,Object>> shopProductOrderDetail(String userId,String orderId,Integer orderStatus);


    List<Map<String, Object>> addShopProductCartOrder(String userId,String ids,String postDateId,Integer payWay,String remark,String addressId);

    List<Map<String, Object>> addShopProductOrder(String userId,String id,Integer buyNum,String postDateId,Integer payWay,String remark,String addressId);

    Map<String,Object> selectPostDateAndWay(String userId);

    Map<String,Object> updateOrderStatus(String orderId,Integer orderStatus) throws Exception;

}
