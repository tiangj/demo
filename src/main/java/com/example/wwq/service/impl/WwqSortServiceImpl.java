package com.example.wwq.service.impl;

import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.example.wwq.entity.WwqSort;
import com.example.wwq.kit.FileHeadHelper;
import com.example.wwq.mapper.WwqSortMapper;
import com.example.wwq.service.IWwqSortService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品分类表 服务实现类
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
@Service
public class WwqSortServiceImpl extends ServiceImpl<WwqSortMapper, WwqSort> implements IWwqSortService {

    @Autowired
    private WwqSortMapper wwqSortMapper;

   @Override
    public PageInfo<Map<String, Object>> shopSortList(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String,Object>> list = wwqSortMapper.shopSortList(FileHeadHelper.FILE_HEAD);
        PageInfo<Map<String,Object>> pageShopSort = new PageInfo<Map<String,Object>>(list);
        return pageShopSort;
    }

    @Override
    public Map<String,Object> shopSortSecondInfo(String id){
        Map<String, Object> example = new HashMap<String, Object>();
        example.put("fileHead", FileHeadHelper.FILE_HEAD);
        example.put("id", id);
        Map<String,Object> map = wwqSortMapper.shopSortSecondInfo(example);
        return map;
    }
}
