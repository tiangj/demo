package com.example.wwq.wx.menu;

import com.example.wwq.pay.kit.IWxPayConfig;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;

public class MenuKit {

    //创建菜单
    public static boolean createMenu(String token,String menu) throws ParseException, IOException {
        String url = IWxPayConfig.CREATE_MENU_URL.replace("ACCESS_TOKEN", token);
        String result = HttpRequestKit.httpRequest(url,menu);
        System.out.println("result:"+result);
        return true;
    }
}
