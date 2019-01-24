package com.example.wwq.controller;

import com.example.wwq.entity.WwqShareUserConcart;
import com.example.wwq.service.IWwqShareUserConcartService;
import com.example.wwq.wxcode.util.MessageUtil;
import com.example.wwq.wxcode.util.TextMessage;
import com.example.wwq.wxcode.util.WxCheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/wwqWxcode")
public class WwqWxcodeController {


    @Autowired
    private IWwqShareUserConcartService wwqShareUserConcartService;

    @RequestMapping(value="/verification")
    public String verification(HttpServletRequest request, HttpServletResponse response) throws Exception{
        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
//		String echostr = request.getParameter("echostr");

        if (WxCheckUtil.checkSignature(signature, timestamp, nonce)) {
            return null;
        }
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        // 调用核心业务类接收消息、处理消息
        String respMessage = this.processRequest(request);
        //响应消息
        PrintWriter out = response.getWriter();
        out.print(respMessage);
        out.flush();
        out.close();
        return null;
    }



    public String processRequest(HttpServletRequest request) {
        String respMessage = null;
        try {
            // 默认返回的文本消息内容
            String respContent = "请求处理异常，请稍候尝试！";

            // xml请求解析
            Map<String, String> requestMap = MessageUtil.parseXml(request);
            // 发送方帐号（open_id）
            String fromUserName = requestMap.get("FromUserName");
            // 公众帐号
            String toUserName = requestMap.get("ToUserName");
            // 消息类型
            String msgType = requestMap.get("MsgType");
            //微信服务器post过来的内容
            String weixinContent = requestMap.get("Content");
            //事件KEY值，qrscene_为前缀，后面为二维码的参数值
            String eventKey = requestMap.get("EventKey");
            String userId = eventKey.substring(eventKey.lastIndexOf('_')+1);
            System.out.println("userId-------------->"+userId);
            //二维码的ticket，可用来换取二维码图片
            String ticket = requestMap.get("Ticket");
            //事件类型，SCAN
            String event = requestMap.get("Event");
            if (event.equals("subscribe")) {
                if(userId != null && fromUserName != null){
                    //待实现
                    WwqShareUserConcart wwqShareUserConcart = new WwqShareUserConcart();
                    wwqShareUserConcart.setUserId(userId);
                    wwqShareUserConcart.setParentId(fromUserName);
                    wwqShareUserConcart.setDeleteFlag(0);
                    wwqShareUserConcart.setCreateDate(new Date());
                    wwqShareUserConcart.setCreateUser(userId);
                    wwqShareUserConcart.setUpdateDate(new Date());
                    wwqShareUserConcart.setUpdateUser(userId);
                    wwqShareUserConcartService.insert(wwqShareUserConcart);
                }
            }else if(event.equals("unsubscribe")){
                if(fromUserName != null){
                    //待实现

                }
                return event;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respMessage;
    }
}
