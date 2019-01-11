package com.example.wwq.wx.kit;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.nio.charset.Charset;

public class HttpClientUtil {
  
	    /**
	     * POST����
	     * @author Jim 2016��8��5�� 
	     * @param url �����Url
	     * @param paramsMap ����Ĳ���Map
	     * @return
	     */
	    public static String post(String url, String str) { 
	    	
	    	CloseableHttpClient httpclient = HttpClients.createDefault();
	    	HttpPost httpPost = new HttpPost(url);
	    	String result = null; 
	    	StringEntity entity = new StringEntity(str, Charset.forName("UTF-8"));
	        entity.setContentEncoding("UTF-8");
	        entity.setContentType("application/json");
	        try {
	        	httpPost.setEntity(entity);
	        	CloseableHttpResponse response = httpclient.execute(httpPost);
	        	
				HttpEntity entity1 = response.getEntity();
				
				result = EntityUtils.toString(entity1);
				EntityUtils.consume(entity);
				response.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	        return result;
	    }  
	    
	
	    public static void get(String url) {
	    	CloseableHttpClient httpclient = HttpClients.createDefault();
	    	HttpGet httpGet = new HttpGet(url);
	    	try {
	    		CloseableHttpResponse response = httpclient.execute(httpGet);
				response.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	    } 
	    
	  
	    public static String getWithResult1(String url) {
	    	CloseableHttpClient httpclient = HttpClients.createDefault();
	    	HttpGet httpGet = new HttpGet(url);
	    	httpGet.setHeader(
	    	            new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8"));

	    	        //设置期望服务端返回的编码
	    	httpGet.setHeader(new BasicHeader("Accept", "application/json;charset=utf-8"));
	    	String result = null; 
	    	
	    	try {
	    		CloseableHttpResponse response = httpclient.execute(httpGet);
	    		HttpEntity entity = response.getEntity();
	    		result = EntityUtils.toString(entity);
	    		//entity.getContent();
				EntityUtils.consume(entity);
				response.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	        return result;  
	    } 
	    
	    
	    public static byte[] getWithResult(String url) {
	    	CloseableHttpClient httpclient = HttpClients.createDefault();
	    	HttpGet httpGet = new HttpGet(url);
	    	httpGet.setHeader(
	    	            new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8"));

	    	        //设置期望服务端返回的编码
	    	httpGet.setHeader(new BasicHeader("Accept", "application/json;charset=utf-8"));
	    	byte[] result = null; 
	    	
	    	try {
	    		CloseableHttpResponse response = httpclient.execute(httpGet);
//	    		HttpEntity entity = response.getEntity();
//	    		result = EntityUtils.toString(entity); 
//	    		//entity.getContent();
//				EntityUtils.consume(entity); 
//				response.close();
	    		result = EntityUtils.toByteArray(response.getEntity());
			} catch (Exception e) {
				e.printStackTrace();
			}
	        return result;  
	    }
	    
	    public static void main(String[] args) {
	    	String url = "http://192.168.2.15:1521/IXTCenter/copyrightRecord/getRecordPDFPath.do?recordDetailId=b9c83b2ee852471489427d055b564902";
	    	get(url);
		}
	    
	}


