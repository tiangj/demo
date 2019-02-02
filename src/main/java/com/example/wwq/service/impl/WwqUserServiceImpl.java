package com.example.wwq.service.impl;

import com.example.wwq.entity.WwqShareCount;
import com.example.wwq.entity.WwqUser;
import com.example.wwq.mapper.WwqShareCountMapper;
import com.example.wwq.mapper.WwqUserMapper;
import com.example.wwq.service.IWwqUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.wwq.wx.Util.WechatKit;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.imageio.stream.FileImageOutputStream;
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

    @Autowired
    private WwqShareCountMapper wwqShareCountMapper;

    @Value("${upload.file.path}")
    private String uploadFolder;

    @Value("${file.staticAccessPath}")
    private String staticAccessPath;


    @Value("${base.uploadFile.server}")
    private String uploadFile;

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
        List<Map<String, Object>> userList = wwqUserMapper.selectInfoById(example);
        if(userList == null || userList.size() < 1){
            //做插入操作
            wwqUserMapper.insert(shopUser);
            List<Map<String, Object>> userList1 = wwqUserMapper.selectInfoById(example);
            try {
                if (StringUtils.isBlank(userList1.get(0).get("phone").toString())) {
                    map.put("code", 200);
                    map.put("userList1", userList1);
                } else {
                    map.put("code", 300);
                    map.put("userList1", userList1);
                }
            }catch (Exception e){
                map.put("code", 300);
                map.put("userList1", userList1);
            }
            return map;
        }else{
            shopUser.setId(userList.get(0).get("id").toString());
            wwqUserMapper.updateById(shopUser);
            //返回用户信息
            //String phone = userList.get(0).get("phone").toString();
            try {
                if (StringUtils.isBlank(userList.get(0).get("phone").toString())) {
                    map.put("code", 200);
                    map.put("userList1", userList);
                } else {
                    map.put("code", 300);
                    map.put("userList1", userList);
                }
            }catch (Exception e){
                map.put("code", 300);
                map.put("userList1", userList);
            }
            return map;
        }
    }


    @Override
    public boolean updateUserPhone(String phone, String userId) {
        try {
            WwqUser shopUser = new WwqUser();
            shopUser.setPhone(phone);
            shopUser.setId(userId);
            String filePath = staticAccessPath+"/"+userId+".jpg";
            String wxCode = uploadFile+WechatKit.productWxCodeUtil(userId,filePath);
            shopUser.setWxCode(wxCode);
            wwqUserMapper.updateById(shopUser);
            //判断是否有分销记录
            WwqShareCount wwqShareCount1 = new WwqShareCount();
            wwqShareCount1.setUserId(userId);
            WwqShareCount wwqShareCount2 = wwqShareCountMapper.selectOne(wwqShareCount1);
            if(wwqShareCount2 == null){
                WwqShareCount wwqShareCount = new WwqShareCount();
                wwqShareCount.setUserId(userId);
                wwqShareCount.setCreateDate(new Date());
                wwqShareCount.setCreateUser(userId);
                wwqShareCount.setDeleteFlag(0);
                wwqShareCount.setUserId(userId);
                wwqShareCount.setFirstShareNum(0);
                wwqShareCount.setSecondShareNum(0);
                wwqShareCount.setUserLevel(1);
                wwqShareCount.setUpdateDate(new Date());
                wwqShareCount.setUpdateUser(userId);
                wwqShareCountMapper.insert(wwqShareCount);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }



    @Override
    public  List<Map<String,Object>> selectUserInfo(String userId) {
        Map<String,Object> map = new HashMap<>();
        map.put("openid",userId);
        List<Map<String,Object>> user = wwqUserMapper.selectInfoById(map);
        return  user;
    }


    @Override
    public Map<String,Object> selectUserInfo1(String userId) {
        Map<String,Object> map = new HashMap<>();
        WwqUser user = wwqUserMapper.selectById(userId);
        //查询用户身份
        WwqShareCount shareCount1 = new WwqShareCount();
        shareCount1.setUserId(userId);
        WwqShareCount shareCount = wwqShareCountMapper.selectOne(shareCount1);
        System.out.println("shareCount:"+shareCount);
        map.put("id",user.getId());
        map.put("nickname",user.getNickname());
        map.put("headimgurl",user.getHeadimgurl());
        map.put("wxCode",user.getWxCode());
        map.put("phone",user.getPhone());
        if(shareCount == null){
            map.put("userLevel", "");
        }else {
            if (shareCount.getUserLevel() != null) {
                map.put("userLevel", shareCount.getUserLevel());
            } else {
                map.put("userLevel", "");
            }
        }
        return  map;
    }
}
