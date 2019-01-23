package com.example.wwq.mapper;

import com.example.wwq.entity.WwqUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
public interface WwqUserMapper extends BaseMapper<WwqUser> {

    List<Map<String,Object>> getShopUserInfo(Map<String,Object> map);


    List<Map<String,Object>> selectInfoById(Map<String,Object> map);
}
