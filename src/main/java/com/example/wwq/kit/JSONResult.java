package com.example.wwq.kit;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.kit.JsonKit;

/**
 * 返回前端接收的json格式
 * @author yz 2017年2月24日 上午10:21:48
 */
public class JSONResult {

	/**
	 * 返回map
	 * @author yz 2017年2月24日 上午10:04:47
	 * @param statusCode
	 * @param message
	 * @return
	 */
	public static Map<String, Object> map(int statusCode, String message) {
		return map(statusCode, message, null);
	}

	/**
	 * 返回map
	 * @author yz 2017年2月24日 上午10:06:23
	 * @param statusCode
	 * @param message
	 * @param data
	 * @return
	 */
	public static Map<String, Object> map(int statusCode, String message, Object data) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("statusCode", statusCode);
		map.put("message", message);
		if(data!=null){
			map.put("data", data);
		}
		return map;
	}
	
	/**
	 * 返回json字符串
	 * @param statusCode
	 * @param message
	 * @return {"message":"操作成功!","statusCode":200}
	 */
	public static String init(int statusCode, String message) {
		return JsonKit.toJson(map(statusCode, message));
	}

	/**
	 * 返回json字符串
	 * @param statusCode
	 * @param message
	 * @param data
	 * @return {"message":"操作成功!","statusCode":200,"data":""}
	 */
	public static String init(int statusCode, String message, Object data) {
		return JsonKit.toJson(map(statusCode, message, data));
	}
	
	/**
	 * 返回json字符串
	 * @author yz 2017年2月24日 上午10:07:12
	 * @return
	 */
	public static String success() {
		return success("success!");
	}
	
	/**
	 * 返回json字符串
	 * @author yz 2017年2月24日 上午10:07:12
	 * @return
	 */
	public static String success(String message) {
		return success(message, null);
	}
	
	/**
	 * 返回json字符串
	 * @author yz 2017年2月24日 上午10:07:12
	 * @return
	 */
	public static String success(String message, Object data) {
		return JsonKit.toJson(map(200, message, data));
	}
	
	/**
	 * 返回json字符串
	 * @author yz 2017年2月24日 上午10:07:12
	 * @return
	 */
	public static String error() {
		return error("error!");
	}
	
	/**
	 * 返回json字符串
	 * @author yz 2017年2月24日 上午10:07:12
	 * @return
	 */
	public static String error(String message) {
		return error(message, null);
	}
	
	/**
	 * 返回json字符串
	 * @author yz 2017年2月24日 上午10:07:12
	 * @return
	 */
	public static String error(String message, Object data) {
		return JsonKit.toJson(map(500, message, data));
	}
	
	/**
	 * 返回json字符串
	 * @author yz 2017年2月24日 上午10:07:12
	 * @return
	 */
	public static String timeout() {
		return JsonKit.toJson(map(301, "会话超时!"));
	}
}

