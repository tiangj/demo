package com.example.wwq.mapper;

import com.example.wwq.entity.WwqShareUserConcart;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 分销用户关联表 Mapper 接口
 * </p>
 *
 * @author generator-plus123
 * @since 2019-01-12
 */
public interface WwqShareUserConcartMapper extends BaseMapper<WwqShareUserConcart> {

    List<Map<String,Object>> userConcatList(String userId);


}
