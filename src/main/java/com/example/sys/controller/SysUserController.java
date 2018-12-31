package com.example.sys.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.sys.entity.SysUser;
import com.example.sys.service.ISysUserService;
import com.example.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户表（权限） 前端控制器
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-27
 */
@Controller
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    @RequestMapping("list")
    public String toUserList(){
        return "sys/userList";
    }

    @RequestMapping("listData")
    @ResponseBody
    public Map<String,Object> listData(Integer page, Integer limit, String username , String name){
        Page<SysUser> sysUserPage=new Page<>();
        sysUserPage.setLimit(limit);
        sysUserPage.setCurrent(page);
        EntityWrapper<SysUser> userEntityWrapper=new EntityWrapper<>();
        userEntityWrapper.like("login_name",username);
        userEntityWrapper.like("name",name);

        Page<SysUser> userPage=sysUserService.selectPage(sysUserPage,userEntityWrapper);
        Map<String,Object> result=new HashMap<>();
        result.put("code",0);
        result.put("msg","");
        result.put("count",userPage.getTotal());
        result.put("data",userPage.getRecords());
        return result;
    }

    @RequestMapping("userAdd")
    public String add(Model model,Integer id){
        SysUser sysUser=null;
        if(id==null){
            sysUser=new SysUser();
        }else{
            sysUser=sysUserService.selectById(id);
            sysUser.setPassword(MD5Util.decodeBase64(sysUser.getPassword()));
        }
        model.addAttribute("sysUser",sysUser);
       return "sys/userAdd";
    }

    @ResponseBody
    @RequestMapping("saveUser")
    public Map<String,Object> saveUser(SysUser sysUser){
        sysUser.setPassword(MD5Util.encodeBase64(sysUser.getPassword()));
        boolean flag=sysUserService.insertOrUpdate(sysUser);
        Map<String,Object> result=new HashMap<>();
        if(flag){
            result.put("code",1);
            result.put("msg","操作成功");
        }else {
            result.put("code",0);
            result.put("msg","操作失败");
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("delUser")
    public Map<String,Object> delUser(Integer id){
        boolean flag=sysUserService.deleteById(id);
        Map<String,Object> result=new HashMap<>();
        if(flag){
            result.put("code",1);
            result.put("msg","删除成功");
        }else {
            result.put("code",0);
            result.put("msg","删除失败");
        }
        return result;
    }
}

