package com.example.wwq.wx.Util;

import com.alibaba.fastjson.JSONObject;
import com.example.wwq.wx.bean.ActionInfo;
import com.example.wwq.wx.bean.Scene;
import com.example.wwq.wx.bean.Ticket;
import com.example.wwq.wx.kit.Enum1;
import com.example.wwq.wx.kit.HttpClientUtil;
import com.example.wwq.wx.kit.UrlUtil;
import javax.imageio.stream.FileImageOutputStream;
import java.io.File;
import com.alibaba.fastjson.JSON;

public class WechatKit {

    public static String productWxCodeUtil(String id,String filePath)throws Exception {
        //第一步
        String url = UrlUtil.ACCESS_TOKEN_URL_HEAD +"&appid="+UrlUtil.APPID+"&secret="+UrlUtil.APPSECRET;
        HttpClientUtil httpClientUtil = new HttpClientUtil();
        String accessTokenJson = httpClientUtil.getWithResult1(url);
        JSONObject json = JSON.parseObject(accessTokenJson);
        System.out.println("json："+json);
        //第二步
        String ticket_url = UrlUtil.TICKET_URL_HEAD+json.getString("access_token");
        System.out.println("ticket_url:"+ticket_url);
        Ticket ticket = new Ticket();
        //构造参数jsonString
        ActionInfo actionInfo = new ActionInfo();
        Scene scene = new Scene();
        scene.setScene_str(id);
        actionInfo.setScene(scene);
        ticket.setAction_name(Enum1.ACTION_NAME);
        ticket.setAction_info(actionInfo);
        String jsonString = JSON.toJSONString(ticket);
        String ticketJson = httpClientUtil.post(ticket_url, jsonString);
        JSONObject json1 = JSON.parseObject(ticketJson);
        //第三步
        String qr_code_url = UrlUtil.QR_CODE_HEAD + json1.getString("ticket");
        byte[] qrCodeJson = httpClientUtil.getWithResult(qr_code_url);
        System.out.println(qrCodeJson.length);
        String wxCode = filePath;
        File file = new File(wxCode);
        if (!file.exists()) {   //文件不存在则创建文件，先创建目录
            File dir = new File(file.getParent());
            dir.mkdirs();
            file.createNewFile();
        }
        FileImageOutputStream imageOutput = new FileImageOutputStream(file);//打开输入流
        imageOutput.write(qrCodeJson);
        if (imageOutput!=null) {
            return wxCode;
        }else {
            return null;
        }
    }
}
