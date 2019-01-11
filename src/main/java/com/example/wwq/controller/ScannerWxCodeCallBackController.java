package com.example.wwq.controller;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;


/**
 * 用户扫描带场景之的微信永久二维码，微信推送事件处理
 */
@Controller
@RequestMapping("/scannerWxCodeCallBack")
public class ScannerWxCodeCallBackController {


    @RequestMapping("callBack")
    public void callBack(@RequestBody(required=false) String body, HttpServletRequest request, HttpServletResponse response){
        System.out.println(body);
        System.out.println("================================微信URL回调测试=========================");
        SAXReader saxReader = new SAXReader();
        Document document;
        try {
            try {
                document = saxReader.read(new ByteArrayInputStream(body.getBytes("UTF-8")));
                Element rootElt = document.getRootElement();
                System.out.println("FromUserName==="+rootElt.elementText("FromUserName"));
                System.out.println("ToUserName==="+rootElt.elementText("ToUserName"));
                System.out.println("CreateTime==="+rootElt.elementText("CreateTime"));
                System.out.println("MsgType==="+rootElt.elementText("MsgType"));
                System.out.println("Event==="+rootElt.elementText("Event"));
                System.out.println("EventKey==="+rootElt.elementText("EventKey"));
                System.out.println("Ticket==="+rootElt.elementText("Ticket"));
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
