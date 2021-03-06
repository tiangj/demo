package com.example.wwq.mapper;

import com.example.wwq.entity.WwqUserShareAmountDetail;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户分享返利提现明细表 Mapper 接口
 * </p>
 *
 * @author generator-plus123
 * @since 2019-01-12
 */
public interface WwqUserShareAmountDetailMapper extends BaseMapper<WwqUserShareAmountDetail> {


    List<Map<String,Object>> userShareCountAmountDetail(String userId);
}
