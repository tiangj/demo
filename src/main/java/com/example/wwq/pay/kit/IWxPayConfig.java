package com.example.wwq.pay.kit;

public interface IWxPayConfig {

//	#微信公众号支付配置
//	#公众账号IDwx74e42bbb4b4e960e
//	#wx.wxPublicPay.appId=wx1e944f4a5d4ac9e0(数音)
//	wx.wxPublicPay.appId=wx74e42bbb4b4e960e
//	#商户号
//	#wx.wxPublicPay.mch_id=1377984302(数音)
//	wx.wxPublicPay.mch_id=1219081801
//	#支付模式
//	wx.wxPublicPay.trade_type=JSAPI
//	#微信公众号支付回调地址(打赏)
//	wx.wxPublicPay.notify_url=http://121.43.112.187:1524/ixtpayment/wxPublicPay/wxPublicPayNotify
//	#微信公众号支付回调地址(打赏分成)
//	wx.wxPublicPay.notify_url1=http://121.43.112.187:1524/ixtpayment/wxPublicPayDivide/wxPublicPayNotify
//	#微信公众号支付签名密钥
//	wx.wxPublicPay.partnerkey=zhengyin20170104139xxxx868100001
	//象谷传媒
	public static String WX_WXPUBLIC_APPID = "wx4dc254fa5905cd27";
	//象谷传媒
	public static String WX_WXPUBLIC_MATCH_ID = "1520869731";
	//支付模式
	public static String WX_WXPUBLIC_TRADE_TYPE = "JSAPI";
	//回调地址
	public static String    WX_WXPUBLIC_NOTITY_URL = "http://test.zhongbohn.com/demo/wxPayCallBack/callBack";
	//暂时使用象谷传媒的秘钥
	public static String WX_WXPUBLIC_PARTNER_KEY = "wanwuanquan201901128888888888888";

	public static  String CREATE_MENU_URL = " https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
}
