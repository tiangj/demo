package com.example.wwq.wx.kit;

public interface UrlUtil {

	public static String APPID = "wx4dc254fa5905cd27";
	
	public static String APPSECRET ="95d214a1825edbf4ccb9da63846dc9a3";
	
	public static String ACCESS_TOKEN_URL_HEAD = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";
	
	public static String TICKET_URL_HEAD = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=";
	
	public static String QR_CODE_HEAD = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";
	
}
