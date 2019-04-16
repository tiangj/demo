package com.example.wwq.controller;

import com.example.wwq.entity.WwqShareUserConcart;
import com.example.wwq.service.IWwqShareUserConcartService;
import com.example.wwq.wxcode.util.MessageUtil;
import com.example.wwq.wxcode.util.TextMessage;
import com.example.wwq.wxcode.util.WxCheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/wwqWxcode")
public class WwqWxcodeController {

    @Autowired
    private IWwqShareUserConcartService wwqShareUserConcartService;



    @RequestMapping(value="/verification")
    public ModelAndView verification(HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("进入了回调！");
        System.out.println("域名："+request.getServerName());
        // 微信加密签名
        String signature = request.getParameter("signature");
        System.out.println("signature"+signature);
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
		String echostr = request.getParameter("echostr");
        boolean isGet = request.getMethod().toLowerCase().equals("get");
        if (isGet) {
           WxCheckUtil.checkSignature(signature, timestamp, nonce);
            PrintWriter out = response.getWriter();
            out.print(echostr);
            out.close();
            //out = null;
        }else {
            // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            // 调用核心业务类接收消息、处理消息
            String respMessage = this.processRequest(request);
            System.out.println(respMessage);
            System.out.println("51");
            //响应消息
            PrintWriter out = response.getWriter();
            System.out.println("51");
            out.print(respMessage);
            System.out.println("52");
            out.flush();
            System.out.println("53");
            out.close();
            System.out.println("54");
        }
        return null;
    }



    public String processRequest(HttpServletRequest request) {
        String respMessage = null;
        try {
            // 默认返回的文本消息内容
            String respContent = "请求处理异常，请稍候尝试！";

            // xml请求解析
            Map<String, String> requestMap = MessageUtil.parseXml(request);
            System.out.println("requestMap:"+requestMap);
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
            System.out.println("------------》》》》》》》userId-------------->"+userId);
            //二维码的ticket，可用来换取二维码图片
            String ticket = requestMap.get("Ticket");
            System.out.println("------------》》》》》》》Ticket-------------->"+ticket);
            //事件类型，SCAN
            String event = requestMap.get("Event");
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(toUserName);
            textMessage.setFromUserName(fromUserName);
            textMessage.setContent(weixinContent);
            textMessage.setEvent(event);
            textMessage.setEventKey(eventKey);
            textMessage.setTicket(ticket);
            textMessage.setCreateTime(new Date().getTime());
            System.out.println("1");
            if (event.equals("subscribe")) {
                System.out.println("2");
                if(userId != null && fromUserName != null){
                    System.out.println("3");
                    WwqShareUserConcart wwqShareUserConcart = new WwqShareUserConcart();
                    wwqShareUserConcart.setUserId(userId);
                    wwqShareUserConcart.setParentId(fromUserName);
                    wwqShareUserConcart.setDeleteFlag(0);
                    wwqShareUserConcart.setCreateDate(new Date());
                    wwqShareUserConcart.setCreateUser(userId);
                    wwqShareUserConcart.setUpdateDate(new Date());
                    wwqShareUserConcart.setUpdateUser(userId);
                    wwqShareUserConcartService.createShareUserConcart(wwqShareUserConcart);
                    System.out.println("4");
                }
            }else if(event.equals("unsubscribe")){
                System.out.println("5");
                return event;
            }
            textMessage.setContent("谢谢您的关注");
            respMessage = MessageUtil.textMessageToXml(textMessage).replace(" ","");
            System.out.println("6");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respMessage;
    }
}
