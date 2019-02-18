package com.example.wwq.controller;


import com.example.wwq.entity.WwqScoreMall;
import com.example.wwq.kit.AuthorHelper;
import com.example.wwq.kit.JSONResult;
import com.example.wwq.service.IWwqScoreMallService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 * 积分兑换商城 前端控制器
 * </p>
 *
 * @author generator-plus123
 * @since 2019-01-08
 */
@Controller
@RequestMapping("/wwqScoreMall")
public class WwqScoreMallController {

    @Autowired
    private IWwqScoreMallService wwqScoreMallService;

    @Autowired
    AuthorHelper authorHelper;

    /**
     *可兑换商品列表
     * @return
     */
    @RequestMapping("/scoreMallProductList")
    @ResponseBody
    public String getScoreMallProductList(@RequestParam(value="pageNum",defaultValue="1",required=true) Integer pageNum,
                                          @RequestParam(value="pageSize",defaultValue="10",required=true) Integer pageSize){
        PageInfo<Map<String, Object>> pageInfo = wwqScoreMallService.getScoreMallProductList(pageNum,pageSize);
        return JSONResult.init(200, "success", pageInfo);
    }


    /**
     * 积分兑换
     * @return
     */
    @RequestMapping("/exchangeScoreMallProduct")
    @ResponseBody
    public String exchangeScoreMallProduct(HttpServletRequest req, String id){
        String userId = authorHelper.getUserId(req);
        if(userId == null){
            return JSONResult.init(301, "success", "user not login");
        }
        Boolean b = wwqScoreMallService.exchangeScoreMallProduct(userId,id);
        if(b){
            return JSONResult.init(200, "success", b);
        }else{
            return JSONResult.init(500, "fail", b);
        }

    }


}

