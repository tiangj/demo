package com.example.wwq.pay.kit;

public class WxPayDto
{
  private String orderId;
  private String totalFee;
  private String spbillCreateIp;
  private String notifyUrl;
  private String body;
  private String openId;
  private String attach = "";

  public String getOrderId()
  {
    return this.orderId;
  }

  public void setOrderId(String orderId)
  {
    this.orderId = orderId;
  }

  public String getTotalFee()
  {
    return this.totalFee;
  }

  public void setTotalFee(String totalFee)
  {
    this.totalFee = totalFee;
  }

  public String getSpbillCreateIp()
  {
    return this.spbillCreateIp;
  }

  public void setSpbillCreateIp(String spbillCreateIp)
  {
    this.spbillCreateIp = spbillCreateIp;
  }

  public String getNotifyUrl()
  {
    return this.notifyUrl;
  }

  public void setNotifyUrl(String notifyUrl)
  {
    this.notifyUrl = notifyUrl;
  }

  public String getBody()
  {
    return this.body;
  }

  public void setBody(String body)
  {
    this.body = body;
  }

  public String getOpenId()
  {
    return this.openId;
  }

  public void setOpenId(String openId)
  {
    this.openId = openId;
  }
  public String getAttach() {
    return this.attach == null ? "" : this.attach;
  }
  public void setAttach(String attach) {
    this.attach = attach;
  }
}
