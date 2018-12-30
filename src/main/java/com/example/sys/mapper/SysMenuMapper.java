package com.example.sys.mapper;

import com.example.sys.entity.SysMenu;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-27
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /******
     * 根据用户id获取菜单信息
     * @param userId
     * @return
     */
    List<Map<String,Object>> getMenusByUserId(String userId);

}
