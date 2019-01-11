package com.example.wwq.wx.menu;

import com.alibaba.fastjson.JSON;
import com.example.wwq.wx.kit.HttpClientUtil;
import com.example.wwq.wx.kit.UrlUtil;
import net.sf.json.JSONObject;

public class WeiXinMenuTest {

    public static void main(String[] args){
        try {
            //第一步
            String url = UrlUtil.ACCESS_TOKEN_URL_HEAD +"&appid="+UrlUtil.APPID+"&secret="+UrlUtil.APPSECRET;
            HttpClientUtil httpClientUtil = new HttpClientUtil();
            String accessTokenJson = httpClientUtil.getWithResult1(url);
            com.alibaba.fastjson.JSONObject json = JSON.parseObject(accessTokenJson);
            System.out.println("json："+json);
            //第二步
            String ticket_url = json.getString("access_token");
            String menu = JSONObject.fromObject(Menu.initMenu()).toString();
            boolean result = MenuKit.createMenu(ticket_url, menu);
            if(result){
                System.out.println("创建菜单成功");
            }else{
                System.out.println("创建菜单失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
