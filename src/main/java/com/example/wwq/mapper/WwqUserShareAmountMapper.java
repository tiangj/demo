package com.example.wwq.mapper;

import com.example.wwq.entity.WwqUserShareAmount;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.Map;

/**
 * <p>
 * 用户分享返现统计表 Mapper 接口
 * </p>
 *
 * @author generator-plus123
 * @since 2019-01-12
 */
public interface WwqUserShareAmountMapper extends BaseMapper<WwqUserShareAmount> {


    Map<String,Object> userShareCountAmount(String userId);
}
