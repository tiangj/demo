package com.example.wwq.service.impl;

import com.example.wwq.entity.WwqUser;
import com.example.wwq.mapper.WwqUserMapper;
import com.example.wwq.service.IWwqUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
@Service
public class WwqUserServiceImpl extends ServiceImpl<WwqUserMapper, WwqUser> implements IWwqUserService {

    @Autowired
    private WwqUserMapper wwqUserMapper;

    @Override
    public Map<String, Object> saveUserInfo(JSONObject userInfo) {
        /**
         * {
         * "openid":"omvuf598t-zUePrOBgJL6-vmJdD8",
         * "nickname":"　　　　　　　　",
         * "sex":1,
         * "language":"zh_CN",
         * "city":"长沙","
         * province":"湖南",
         * "country":"中国",
         * "headimgurl":"http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83erbhxK539me9jZhN80bakJYP9dxxDMpvltZ2iat2JNM53aoGCHmiaGec0C1QAVNlBHVWRoUgQicbRrWw/132","privilege":[]}
         */
        /**
         * {
         * "openid":"omvuf598t-zUePrOBgJL6-vmJdD8",
         * "nickname":"　　　　　　　　",
         * "sex":1,
         * "language":"zh_CN",
         * "city":"长沙","
         * province":"湖南",
         * "country":"中国",
         * "headimgurl":"http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83erbhxK539me9jZhN80bakJYP9dxxDMpvltZ2iat2JNM53aoGCHmiaGec0C1QAVNlBHVWRoUgQicbRrWw/132","privilege":[]}
         */
        Map<String, Object> map = new HashMap<String, Object>();
            WwqUser shopUser = new WwqUser();
        shopUser.setCity(userInfo.getString("city"));
        shopUser.setCountry(userInfo.getString("country"));
        shopUser.setHeadimgurl(userInfo.getString("headimgurl"));
        shopUser.setLanguage(userInfo.getString("language"));
        shopUser.setNickname(userInfo.getString("nickname"));
        shopUser.setOpenId(userInfo.getString("openid"));
        shopUser.setProvince(userInfo.getString("province"));
        shopUser.setSex(Integer.parseInt(userInfo.getString("sex")));
        shopUser.setPhone("");
        shopUser.setCreateDate(new Date());
        shopUser.setCreateUser(shopUser.getId());
        shopUser.setUpdateDate(new Date());
        shopUser.setUpdateUser(shopUser.getId());
        //先根据openId判断shopUser是否存在
        Map<String, Object> example = new HashMap<>();
        example.put("openid", userInfo.getString("openid"));
        List<Map<String, Object>> userList = wwqUserMapper.getShopUserInfo(example);
        if(userList == null || userList.size() < 1){
            //做插入操作
            wwqUserMapper.insert(shopUser);
            List<Map<String, Object>> userList1 = wwqUserMapper.getShopUserInfo(example);
            map.put("userList1", userList1);
            map.put("code", 200);
            return map;
        }else{
            shopUser.setId(userList.get(0).get("id").toString());
            wwqUserMapper.updateById(shopUser);
            //返回用户信息
            String phone = userList.get(0).get("phone").toString();
            if(!phone.isEmpty()){
                map.put("code", 200);
                map.put("userList1", userList);
            }else{
                map.put("code", 300);
                map.put("userList1", userList);
            }
            return map;
        }
    }


    @Override
    public boolean updateUserPhone(String phone, String userId) {
        WwqUser shopUser = new WwqUser();
        shopUser.setPhone(phone);
        shopUser.setId(userId);
        wwqUserMapper.updateById(shopUser);
        return true;
    }



    @Override
    public WwqUser selectUserInfo(String userId) {
        WwqUser user = wwqUserMapper.selectById(userId);
        return  user;
    }
}
