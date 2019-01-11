package com.example.wwq.pay.kit;



import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;



public class WechatPayUtil {

  public static String getPackage(WxPayDto tpWxPayDto) throws UnsupportedEncodingException {
    String openId = tpWxPayDto.getOpenId();
    String orderId = tpWxPayDto.getOrderId();
    String attach = tpWxPayDto.getAttach();
    String totalFee = getMoney(tpWxPayDto.getTotalFee());
    String spbill_create_ip = tpWxPayDto.getSpbillCreateIp();
    String notify_url = WechatBaseConfig.url_notify;
    String trade_type = "JSAPI";
    String mch_id = WechatBaseConfig.partner;
    String nonce_str = getNonceStr();
    String body = tpWxPayDto.getBody();
    String out_trade_no = orderId;
    SortedMap<String, Object> packageParams = new TreeMap<String, Object>();
    packageParams.put("appid", WechatBaseConfig.appid);
    packageParams.put("mch_id", mch_id);
    packageParams.put("nonce_str", nonce_str);
    packageParams.put("body", body);
    packageParams.put("attach", attach);
    packageParams.put("out_trade_no", out_trade_no);
    packageParams.put("total_fee", totalFee);
    packageParams.put("spbill_create_ip", spbill_create_ip);
    packageParams.put("notify_url", notify_url);
    packageParams.put("trade_type", trade_type);
    packageParams.put("openid", openId);
    RequestHandler reqHandler = new RequestHandler();
    String sign = reqHandler.createSign(packageParams);
    packageParams.put("sign", sign);
    packageParams.put("body", "<![CDATA[" + body + "]]>");
    String xml = WechatXMLConfig.getXMLByMap(packageParams);
    String prepay_id = GetWxOrderno.getPayNo(xml);
    SortedMap<String, Object> finalpackage = new TreeMap<String, Object>();
    String timestamp = Sha1Util.getTimeStamp();
    String packages = "prepay_id=" + prepay_id;
    finalpackage.put("appId", WechatBaseConfig.appid);
    finalpackage.put("timeStamp", timestamp);
    finalpackage.put("nonceStr", nonce_str);
    finalpackage.put("package", packages);
    finalpackage.put("signType", "MD5");
    String finalsign = reqHandler.createSign(finalpackage);
    String finaPackage = "\"appId\":\"" + WechatBaseConfig.appid + "\",\"timeStamp\":\"" + timestamp + 
      "\",\"nonceStr\":\"" + nonce_str + "\",\"package\":\"" + 
      packages + "\",\"signType\" : \"MD5" + "\",\"paySign\":\"" + 
      finalsign + "\"";
    return finaPackage;
  }

  public static String getNonceStr()
  {
    String str = String.valueOf(new Random().nextLong());
    return str.substring(str.length() - 10);
  }

  public static String getMoney(String amount)
  {
    if (amount == null) {
      return "";
    }

    String currency = amount.replaceAll("\\$|\\￥|\\,", "");
    int index = currency.indexOf(".");
    int length = currency.length();
    Long amLong = Long.valueOf(0L);
    if (index == -1)
      amLong = Long.valueOf(currency + "00");
    else if (length - index >= 3)
      amLong = Long.valueOf(currency.substring(0, index + 3).replace(".", ""));
    else if (length - index == 2)
      amLong = Long.valueOf(currency.substring(0, index + 2).replace(".", "") + 0);
    else {
      amLong = Long.valueOf(currency.substring(0, index + 1).replace(".", "") + "00");
    }
    return amLong.toString();
  }
}