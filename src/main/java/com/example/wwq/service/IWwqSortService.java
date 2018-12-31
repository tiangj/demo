package com.example.wwq.service;

import com.example.wwq.entity.WwqSort;
import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * <p>
 * 商品分类表 服务类
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
public interface IWwqSortService extends IService<WwqSort> {

    PageInfo<Map<String, Object>> shopSortList(Integer pageNum, Integer pageSize);

    Map<String,Object> shopSortSecondInfo(String id);
}
