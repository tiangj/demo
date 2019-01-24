package com.example.wwq.controller;

import com.example.wwq.kit.JSONResult;
import com.example.wwq.service.IWwqPayService;
import com.jfinal.kit.JsonKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/testPay")
public class TestPayController {

    @Autowired
    private IWwqPayService wwqPayService;

    @RequestMapping("/payReturn")
    @ResponseBody
    public String payReturn(String orderId){
        wwqPayService.updateOrderStatus(orderId);
        return JSONResult.init(200,"success");
    }
}
