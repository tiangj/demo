package com.example.wwq.service;

import com.example.wwq.entity.WwqBanner;
import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * <p>
 * banner位表 服务类
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
public interface IWwqBannerService extends IService<WwqBanner> {

    PageInfo<Map<String,Object>> shopBannerList(Integer pageNum, Integer pageSize);
}
