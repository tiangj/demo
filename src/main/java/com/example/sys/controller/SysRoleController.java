package com.example.sys.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 权限表 前端控制器
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-27
 */
@Controller
@RequestMapping("/sysRole")
public class SysRoleController {

    /****
     * 跳转至权限list
     * @return
     */
    @RequestMapping("list")
    public String list(){
       return "sys/roleList";
    }
}

