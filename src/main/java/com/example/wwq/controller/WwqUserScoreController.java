package com.example.wwq.controller;


import com.example.wwq.entity.WwqIntegral;
import com.example.wwq.entity.WwqUserScore;
import com.example.wwq.kit.JSONResult;
import com.example.wwq.service.IWwqUserScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
@Controller
@RequestMapping("/wwqUserScore")
public class WwqUserScoreController {

    @Autowired
    private IWwqUserScoreService wwqUserScoreService;

    /**
     * 获取用户积分
     * @param req
     * @return
     */
    @RequestMapping("/userScore")
    @ResponseBody
    public String getUserIntegral(HttpServletRequest req){
        String userId = "1";
//        String userId = authorHelper.getUserId(req);
//        if(userId == null){
//            return JSONResult.init(301, "success", "user not login");
//        }
        WwqUserScore wwqUserScore = wwqUserScoreService.getUserIntegral(userId);
        if(wwqUserScore == null){
            return JSONResult.init(500, "fail");
        }else{
            return JSONResult.init(200, "success",wwqUserScore);
        }
    }
}

