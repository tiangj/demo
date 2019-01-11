package com.example.wwq.pay.kit;


import java.util.Map;
import java.util.Set;




public class WechatXMLConfig
{

  public static String url_pay_unifiedorder = "https://api.mch.weixin.qq.com/pay/unifiedorder";

  public static String url_pay_orderquery = "https://api.mch.weixin.qq.com/pay/orderquery";

  public static String getXMLByMap(Map<String, Object> map)
  {
    //请求xml组装
    StringBuilder sb = new StringBuilder();
    sb.append("<xml>");
    Set es = map.entrySet();
    for (Object e : es) {
      Map.Entry entry = (Map.Entry) e;
      String key = (String) entry.getKey();
      String value = (String) entry.getValue();
      if ("attach".equalsIgnoreCase(key) || "body".equalsIgnoreCase(key) || "sign".equalsIgnoreCase(key)) {
        sb.append("<").append(key).append(">").append("<![CDATA[").append(value).append("]]></").append(key).append(">");
      } else {
        sb.append("<").append(key).append(">").append(value).append("</").append(key).append(">");
      }
    }
    sb.append("</xml>");
    System.out.println(sb.toString());
    return sb.toString();
  }
}