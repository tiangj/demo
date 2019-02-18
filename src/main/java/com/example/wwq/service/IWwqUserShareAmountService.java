package com.example.wwq.service;

import com.example.wwq.entity.WwqUserShareAmount;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * <p>
 * 用户分享返现统计表 服务类
 * </p>
 *
 * @author generator-plus123
 * @since 2019-01-12
 */
public interface IWwqUserShareAmountService extends IService<WwqUserShareAmount> {

    Map<String,Object> userShareCountAmount(String userId);
}
