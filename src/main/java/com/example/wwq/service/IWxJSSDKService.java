package com.example.wwq.service;

import org.springframework.stereotype.Service;

import java.util.Map;


public interface IWxJSSDKService {

    public Map<String, Object> wxJSSDKConfig(String token, String url);
}
