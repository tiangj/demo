package com.example.wwq.pay.kit;



import net.sf.json.xml.XMLSerializer;
import net.sf.json.JSONObject;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetWxOrderno {



  public static String getPayNo(String xmlParam) throws UnsupportedEncodingException {
    String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    try {
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        //加入数据
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        BufferedOutputStream buffOutStr = new BufferedOutputStream(conn.getOutputStream());
        buffOutStr.write(xmlParam.getBytes("UTF-8"));
        buffOutStr.flush();
        buffOutStr.close();
        //获取输入流
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        String line = null;
        StringBuffer sb = new StringBuffer();
        while ((line = reader.readLine()) != null) {
          sb.append(line);
        }
        System.out.println(sb.toString());
        String prepay_id = null;
        XMLSerializer xmlSerializer = new XMLSerializer();
        JSONObject json = (JSONObject)xmlSerializer.read(sb.toString());
        String return_code = json.getString("return_code");
        String return_msg = new String(json.getString("return_msg").getBytes("ISO-8859-1"),"UTF-8");
        System.out.println("return_msg:"+return_msg);
        if ("SUCCESS".equals(return_code)){
            String result_code = json.getString("result_code");
            if ("SUCCESS".equals(result_code)){
                prepay_id = json.getString("prepay_id");
            }else{
                System.out.println("result_code:"+result_code);
                return null;
            }
        }else{

        }
        return prepay_id;
     } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}