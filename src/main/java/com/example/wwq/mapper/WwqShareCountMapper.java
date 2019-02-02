package com.example.wwq.mapper;

import com.example.wwq.entity.WwqShareCount;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 分销统计表 Mapper 接口
 * </p>
 *
 * @author generator-plus123
 * @since 2019-01-11
 */
public interface WwqShareCountMapper extends BaseMapper<WwqShareCount> {


    List<Map<String,Object>> userConcatList(String userId);
}
