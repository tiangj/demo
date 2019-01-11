package com.example.wwq.mapper;

import com.example.wwq.entity.WwqIntegral;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 积分表 Mapper 接口
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
public interface WwqIntegralMapper extends BaseMapper<WwqIntegral> {

    List<WwqIntegral> getUserIntegralList(String userId);
}
