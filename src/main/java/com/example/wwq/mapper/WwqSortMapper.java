package com.example.wwq.mapper;

import com.example.wwq.entity.WwqSort;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品分类表 Mapper 接口
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
public interface WwqSortMapper extends BaseMapper<WwqSort> {

    List<Map<String, Object>> shopSortList(String fileHead);

    Map<String,Object> shopSortSecondInfo( Map<String, Object> example);
}
