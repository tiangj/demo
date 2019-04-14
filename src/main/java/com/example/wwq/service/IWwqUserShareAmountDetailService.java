package com.example.wwq.service;

import com.example.wwq.entity.WwqUserShareAmountDetail;
import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户分享返利提现明细表 服务类
 * </p>
 *
 * @author generator-plus123
 * @since 2019-01-12
 */
public interface IWwqUserShareAmountDetailService extends IService<WwqUserShareAmountDetail> {


    PageInfo<Map<String,Object>> userShareCountAmountDetail(String userId, Integer pageNum, Integer pageSize);
}
