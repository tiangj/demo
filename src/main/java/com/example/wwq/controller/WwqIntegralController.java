package com.example.wwq.controller;


import com.example.wwq.entity.WwqIntegral;
import com.example.wwq.kit.AuthorHelper;
import com.example.wwq.kit.JSONResult;
import com.example.wwq.service.IWwqIntegralService;
import com.jfinal.kit.JsonKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 积分表 前端控制器
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
@Controller
@RequestMapping("/wwqIntegral")
public class WwqIntegralController {

    @Autowired
    private AuthorHelper authorHelper;

    @Autowired
    private IWwqIntegralService wwqIntegralService;

    /**
     * 获取用户积分
     * @param req
     * @return
     */
    @RequestMapping("/userIntegral")
    @ResponseBody
    public String getUserIntegralList(HttpServletRequest req){
        String userId = "1";
//        String userId = authorHelper.getUserId(req);
//        if(userId == null){
//            return JSONResult.init(301, "success", "user not login");
//        }
        List<WwqIntegral> wwqIntegral = wwqIntegralService.getUserIntegralList(userId);
        if(wwqIntegral == null){
            return JSONResult.init(500, "fail");
        }else{
            return JSONResult.init(200, "success",wwqIntegral);
        }
    }
}

