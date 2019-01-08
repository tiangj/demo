package com.example.wwq.kit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WxLoginHelper {

	@Autowired
	private RedisHelper manager;
		
	public boolean setCode(String code){
		return manager.set("code", code);
		 
	}

	public boolean getCode(String code){
		return manager.exists(code);
	}
	
	public boolean del(String key){
		manager.remove(key);
		return true;
	}
	
	
	public boolean setUserInfo(String key,String value){
		return manager.set(key, value);
	}
	
	public Object getUserInfo(String key){
		return manager.get(key);
	}
}
