package com.example.wwq.kit;


import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;


public class WeCahtUtils {
	//鏀惧叆褰撳墠鍏紬鍙风殑appid鍜宎ppsecret
	public static final String APPID="wx4dc254fa5905cd27";
	public static  final String APPSECRET="95d214a1825edbf4ccb9da63846dc9a3";
    //url 鎺ュ彛鍦板潃

	public  static JSONObject  getJSONObject(String url) throws ClientProtocolException, IOException{
		JSONObject  jsonObject=null;
		//鍒濆鍖朌efaultHttpClient 瀵硅薄
	   DefaultHttpClient client=new DefaultHttpClient();
	   /**
	    * 閫氳繃get鏂瑰紡鎻愪氦
	    * 浣跨敤HTTPget骞朵紶鍏rl鍦板潃
	    * */
		HttpGet  httpGet =new  HttpGet(url);
		//execute鍙戦�璇锋眰
		HttpResponse execute = client.execute(httpGet);
		//杩斿洖缁撴灉闆�
		HttpEntity entity=execute.getEntity();
		//杩斿洖鐨勭粨鏋滀笉涓虹┖
		if(entity!=null){
			//杞崲涓篠tring
			String string = EntityUtils.toString(entity,"UTF-8");
			//杞崲涓簀son鏍煎紡
			jsonObject=JSONObject.fromObject(string);
		}
		//鍏抽棴閾炬帴
		httpGet.releaseConnection();
	return  jsonObject;
	}
	
	
	
}
