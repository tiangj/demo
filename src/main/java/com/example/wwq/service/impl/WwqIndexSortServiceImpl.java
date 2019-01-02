package com.example.wwq.service.impl;

import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.example.wwq.entity.WwqIndexSort;
import com.example.wwq.kit.FileHeadHelper;
import com.example.wwq.mapper.WwqIndexSortMapper;
import com.example.wwq.service.IWwqIndexSortService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 首页大分类 服务实现类
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
@Service
public class WwqIndexSortServiceImpl extends ServiceImpl<WwqIndexSortMapper, WwqIndexSort> implements IWwqIndexSortService {

    @Autowired
    private WwqIndexSortMapper wwqIndexSortMapper;

    @Override
    public PageInfo<Map<String,Object>> ShopIndexSortList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String,Object>> list = wwqIndexSortMapper.shopIndexSortList();
        PageInfo<Map<String,Object>> pageShopIndexSort = new PageInfo<Map<String,Object>>(list);
        return pageShopIndexSort;
    }

}
