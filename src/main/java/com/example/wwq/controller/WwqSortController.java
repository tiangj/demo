package com.example.wwq.controller;


import com.example.wwq.kit.JSONResult;
import com.example.wwq.service.IWwqSortService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * <p>
 * 商品分类表 前端控制器
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
@Controller
@RequestMapping("/wwqSort")
public class WwqSortController {

@Autowired
private IWwqSortService wwqSortService;

    /**
     * 商品一级分类
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/shopSortList",produces= "text/html;charset=UTF-8")
    @ResponseBody
    public String shopSortFirstList(@RequestParam(value="pageNum",defaultValue="1",required=true) Integer pageNum,
                                    @RequestParam(value="pageSize",defaultValue="10",required=true) Integer pageSize){
        PageInfo<Map<String, Object>> pageShopSort = wwqSortService.shopSortList(pageNum, pageSize);
        return JSONResult.init(200, "success", pageShopSort);
    }

    /**
     * 商品二级分类详情
     * @param id
     * @return
     */
    @RequestMapping(value="/shopSortSecondInfo",produces= "text/html;charset=UTF-8")
    @ResponseBody
    public String shopSortSecondInfo(String id){
        Map<String,Object> shopSort = wwqSortService.shopSortSecondInfo(id);
        return JSONResult.init(200, "success", shopSort);
    }

}

