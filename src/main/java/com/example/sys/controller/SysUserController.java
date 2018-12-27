package com.example.sys.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("toUserList")
    public String toUserList(){
        return "sys/userList";
    }
}

