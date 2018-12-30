package com.example.sys.service.impl;

import com.example.sys.entity.SysMenu;
import com.example.sys.mapper.SysMenuMapper;
import com.example.sys.service.ISysMenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-27
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public Map<String, Object> getMenusByUserId(String userId) {
        List<Map<String, Object>> menusList=sysMenuMapper.getMenusByUserId(userId);

        List<Map<String,Object>> firstMenusList=new ArrayList<>();
        List<Map<String,Object>> secondMenusList=new ArrayList<>();
        for (Map<String,Object> menu:menusList){
            if(menu.get("parent_id")==null || "".equals(menu.get("parent_id"))){
                firstMenusList.add(menu);
            }
            if(menu.get("parent_id")!=null && !"".equals(menu.get("parent_id"))){
                secondMenusList.add(menu);
            }
        }
        Map<String,Object> menusResult=new HashMap<>();
        menusResult.put("firstMenusList",firstMenusList);
        menusResult.put("secondMenusList",secondMenusList);
        return menusResult;
    }
}
