package com.example.wwq.service;

import com.example.wwq.entity.WwqIndexSort;
import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * <p>
 * 首页大分类 服务类
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
public interface IWwqIndexSortService extends IService<WwqIndexSort> {

     PageInfo<Map<String,Object>> ShopIndexSortList(Integer pageNum, Integer pageSize);

}
