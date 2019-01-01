package com.example.sys.controller;


import com.example.sys.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-27
 */
@Controller
@RequestMapping("/sysMenu")
public class SysMenuController {

    @Autowired
    private ISysMenuService sysMenuService;

    /****
     * 跳转至菜单list
     * @return
     */
    @RequestMapping("list")
    public String list(){
        return "sys/menuList";
    }

    /****
     * 根据用户id获取菜单信息
     * @return
     */
    @ResponseBody
    @RequestMapping("getMenusByUserId")
    public Map<String,Object> getMenusByUserId(String userId){
        return sysMenuService.getMenusByUserId(userId);
    }

}

