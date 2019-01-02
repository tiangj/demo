package com.example.wwq.mapper;

import com.example.wwq.entity.WwqIndexSort;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 首页大分类 Mapper 接口
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
public interface WwqIndexSortMapper extends BaseMapper<WwqIndexSort> {


    List<Map<String,Object>> shopIndexSortList();
}
