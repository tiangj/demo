package com.example.wwq.service;

import com.example.wwq.entity.WwqScoreMall;
import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * <p>
 * 积分兑换商城 服务类
 * </p>
 *
 * @author generator-plus123
 * @since 2019-01-08
 */
public interface IWwqScoreMallService extends IService<WwqScoreMall> {

    PageInfo<Map<String, Object>> getScoreMallProductList(Integer pageNum, Integer pageSize);

    boolean exchangeScoreMallProduct(String userId,String id);
}
