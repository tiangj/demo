package com.example.wwq.service.impl;

import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.example.wwq.entity.WwqBanner;
import com.example.wwq.kit.FileHeadHelper;
import com.example.wwq.mapper.WwqBannerMapper;
import com.example.wwq.service.IWwqBannerService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * banner位表 服务实现类
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
@Service
public class WwqBannerServiceImpl extends ServiceImpl<WwqBannerMapper, WwqBanner> implements IWwqBannerService {

    @Autowired
    private WwqBannerMapper wwqBannerMapper;

    @Override
    public PageInfo<Map<String,Object>> shopBannerList(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String,Object>> list = wwqBannerMapper.shopBannerList(FileHeadHelper.FILE_HEAD);
        PageInfo<Map<String,Object>> pageShopBanner = new PageInfo<>(list);
        return pageShopBanner;
    }
}
