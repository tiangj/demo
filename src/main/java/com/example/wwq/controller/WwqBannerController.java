package com.example.wwq.controller;


import com.example.wwq.kit.JSONResult;
import com.example.wwq.service.IWwqBannerService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * banner位表 前端控制器
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
@Controller
@RequestMapping("/wwqBanner")
public class WwqBannerController {

@Autowired
private IWwqBannerService wwqBannerService;


    /**
     * 获取首页banner
     * @return
     */
    @RequestMapping("/shopBannerList")
    @ResponseBody
    public String shopBannerList(@RequestParam(value="pageNum",defaultValue="1",required=true) Integer pageNum,
                                 @RequestParam(value="pageSize",defaultValue="10",required=true) Integer pageSize){
        PageInfo<Map<String,Object>> page = wwqBannerService.shopBannerList(pageNum,pageSize);
        return JSONResult.init(200, "success", page);
    }

}

