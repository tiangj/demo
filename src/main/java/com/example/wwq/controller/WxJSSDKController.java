package com.example.wwq.controller;

import com.example.wwq.kit.JSONResult;
import com.example.wwq.service.IWxJSSDKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/wxJSSDK")
public class WxJSSDKController {

    @Autowired
    private IWxJSSDKService wxJSSDKService;

    /**
     * 获取微信公众号JS-SDK获取signature签名以及config配置
     *
     * @return
     */
    @RequestMapping("wxJSSDKConfig")
    @ResponseBody
    public String wxJSSDKConfig(HttpServletRequest req, @RequestParam(value = "url", required = true) String url) {
        String token = req.getHeader("UserToken");
        Map<String, Object> map = wxJSSDKService.wxJSSDKConfig(token, url);
        return JSONResult.init(200, "success", map);
    }
}