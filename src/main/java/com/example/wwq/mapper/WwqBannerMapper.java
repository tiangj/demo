package com.example.wwq.mapper;

import com.example.wwq.entity.WwqBanner;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * banner位表 Mapper 接口
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
public interface WwqBannerMapper extends BaseMapper<WwqBanner> {

    List<Map<String,Object>> shopBannerList(String fileHead);
}
