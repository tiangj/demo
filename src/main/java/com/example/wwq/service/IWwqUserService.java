package com.example.wwq.service;

import com.example.wwq.entity.WwqUser;
import com.baomidou.mybatisplus.service.IService;
import net.sf.json.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
public interface IWwqUserService extends IService<WwqUser> {


    Map<String, Object> saveUserInfo(JSONObject userInfo);

    boolean updateUserPhone(String phone,String userId);

    WwqUser selectUserInfo(String userId);
}
