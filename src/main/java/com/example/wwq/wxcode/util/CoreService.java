package com.example.wwq.wxcode.util;
 
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
 
/**
 * 核心服务类
 * 
 * @author liufeng
 * @date 2013-05-20
 */
public class CoreService {
//	/**
//	 * 处理微信发来的请求
//	 *
//	 * @param request
//	 * @return
//	 */
//	public static String processRequest(HttpServletRequest request) {
//		String respMessage = null;
//		try {
//			// 默认返回的文本消息内容
//			String respContent = "请求处理异常，请稍候尝试！";
//
//			// xml请求解析
//			Map<String, String> requestMap = MessageUtil.parseXml(request);
//			// 发送方帐号（open_id）
//			String fromUserName = requestMap.get("FromUserName");
//			// 公众帐号
//			String toUserName = requestMap.get("ToUserName");
//			// 消息类型
//			String msgType = requestMap.get("MsgType");
//			 //微信服务器post过来的内容
//	        String weixinContent = requestMap.get("Content");
//	        //事件KEY值，qrscene_为前缀，后面为二维码的参数值
//	        String eventKey = requestMap.get("EventKey");
//	        String storeid = eventKey.substring(eventKey.lastIndexOf('_')+1);
//	        System.out.println("openid-------------->"+storeid);
//	        //二维码的ticket，可用来换取二维码图片
//	        String ticket = requestMap.get("Ticket");
//	        //事件类型，SCAN
//	        String event = requestMap.get("Event");
//	        if (event.equals("subscribe")) {
//	        	ShopWxcode shopWxcode = new ShopWxcode();
//	        	shopWxcode.setStoreid(storeid);
//	        	shopWxcode.setWxOpenid(toUserName);
//	        	getShopWxcode(shopWxcode);
//				System.out.println("进来了！");
//			}
//			// 回复文本消息
//			TextMessage textMessage = new TextMessage();
//			textMessage.setToUserName(fromUserName);
//			textMessage.setFromUserName(toUserName);
//			textMessage.setContent(weixinContent);
//			textMessage.setEvent(event);
//			textMessage.setEventKey(eventKey);
//			textMessage.setTicket(ticket);
//			textMessage.setCreateTime(new Date().getTime());
//			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
//
//			// 文本消息
//			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
//				respContent = "敬请期待！";
//				// 自定义菜单点击事件
//			}// 事件推送
//			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
//				// 事件类型
//				String eventType = requestMap.get("Event");
//				// 订阅
//				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
//					respContent = "谢谢您的关注！";
//				}
//				// 取消订阅
//				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
//					// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
//				}
//				// 自定义菜单点击事件
//				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
//					// 事件KEY值，与创建自定义菜单时指定的KEY值对应
//					String eventKey1 = requestMap.get("EventKey");
//					if (eventKey1.equals("https://636.hnguwei.com/mall/mall_main.html")) {
//						respContent = "微信商城被点击！";
//					}
//				}
//			}
//			textMessage.setContent(respContent);
//			respMessage = MessageUtil.textMessageToXml(textMessage);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return respMessage;
//	}
//
//	public static ShopWxcode getShopWxcode(ShopWxcode shopWxcode){
//		return shopWxcode;
//	}
}
