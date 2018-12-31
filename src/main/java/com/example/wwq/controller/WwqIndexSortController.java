package com.example.wwq.controller;


import com.example.wwq.kit.JSONResult;
import com.example.wwq.service.IWwqIndexSortService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * <p>
 * 首页大分类 前端控制器
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
@Controller
@RequestMapping("/wwqIndexSort")
public class WwqIndexSortController {

    @Autowired
    private IWwqIndexSortService wwqIndexSortService;


    /**
     * 获取首页4大模块
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/shopIndexSortList",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String ShopIndexSortList(@RequestParam(value="pageNum",defaultValue="1",required=true) Integer pageNum,
                                    @RequestParam(value="pageSize",defaultValue="10",required=true) Integer pageSize){
        PageInfo<Map<String,Object>> pageShopIndexSort = wwqIndexSortService.ShopIndexSortList(pageNum, pageSize);
        return JSONResult.init(200, "success", pageShopIndexSort);

    }
}

