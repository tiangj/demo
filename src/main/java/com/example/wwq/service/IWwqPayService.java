package com.example.wwq.service;

import com.example.wwq.entity.WwqPay;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品支付表 服务类
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
public interface IWwqPayService extends IService<WwqPay> {


    String creatPayOrderRecord(String userId, List<Map<String, Object>> orderList);

    Map<String,Object> wxJSAPIPay(String renoteAddr,String orderId,String userId);

    boolean updateOrderStatus(String orderId);
}
