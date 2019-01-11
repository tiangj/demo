package com.example.wwq.pay.kit;

import java.text.MessageFormat;

public class WechatBaseConfig
{
  @SuppressWarnings("unused")
private static String appid1 = "wx452478ee9eda3c99";
  @SuppressWarnings("unused")
private static String appsecret1 = "f64c42e8705b700f83981e6ad351d83e";

  private static String appid2 = "wx74e42bbb4b4e960e";
  private static String appsecret2 = "78c3ef9e690bd8aa91cb2bf12fe31506";

  public static String appid3 = "wxacd7948964569cab";
  public static String appsecret3 = "6a00849338e7a45e26eba41da68709c2";

  public static String appid = appid2;
  public static String appsecret = appsecret2;

  public static String partner = "1219081801";

  public static String partnerkey = "zhengyin20170104139xxxx868100001";

  public static String url_notify = "http://www.ixingtu.com/ixtPay/wxpay/notify.do";

  public static String url_qrcode = "{0}";

  public static String url_authorize_base = "https://open.weixin.qq.com/connect/oauth2/authorize?appid={0}&redirect_uri={1}&response_type=code&scope=snsapi_base&state={2}#wechat_redirect";

  public static String url_authorize_userinfo = "https://open.weixin.qq.com/connect/oauth2/authorize?appid={0}&redirect_uri={1}&response_type=code&scope=snsapi_userinfo&state={2}#wechat_redirect";

  public static String url_access_token = "https://api.weixin.qq.com/sns/oauth2/access_token?appid={0}&secret={1}&code={2}&grant_type=authorization_code";

  public static String url_refresh_token = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid={0}&grant_type=refresh_token&refresh_token={1}";

  public static String url_auth = "https://api.weixin.qq.com/sns/auth?access_token={0}&openid={1}";

  public static String url_qrconnect = "https://open.weixin.qq.com/connect/qrconnect?appid={0}&redirect_uri={1}&response_type=code&scope=snsapi_login&state={2}#wechat_redirect";

  public static String url_userinfo = "https://api.weixin.qq.com/sns/userinfo?access_token={0}&openid={1}&lang=zh_CN";

  public static String getUrl_authorize_base(String redirectUri, String state)
  {
    return MessageFormat.format(url_authorize_base, new Object[] { appid, redirectUri, state });
  }

  public static String getUrl_authorize_userinfo(String redirectUri, String state)
  {
    return MessageFormat.format(url_authorize_userinfo, new Object[] { appid, redirectUri, state });
  }

  public static String getUrl_access_token(String code)
  {
    return MessageFormat.format(url_access_token, new Object[] { appid, appsecret, code });
  }

  public static String getUrl_refresh_token(String refreshToken)
  {
    return MessageFormat.format(url_refresh_token, new Object[] { appid, refreshToken });
  }

  public static String getUrl_userinfo(String accessToken, String openId)
  {
    return MessageFormat.format(url_userinfo, new Object[] { accessToken, openId });
  }

  public static String getUrl_auth(String accessToken, String openId)
  {
    return MessageFormat.format(url_auth, new Object[] { accessToken, openId });
  }

  public static String getUrl_qrconnect(String redirectUri, String state)
  {
    return MessageFormat.format(url_qrconnect, new Object[] { appid, redirectUri, state });
  }
}
