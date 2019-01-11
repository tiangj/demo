package com.example.wwq.kit;

import com.example.wwq.entity.WwqUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;


@Service
public class AuthorHelper {
    @Autowired
    private RedisHelper manager;


    /**
     * 构造登录token
     * @param user
     * @return
     */
    public String setSession(WwqUser user){
        //生成token,设置token过期时间15天
        String token = java.util.UUID.randomUUID().toString().replaceAll("-", "");
        Boolean b = manager.set(token, user, 1296000L);
        if(b){
            return token;
        }else{
            return null;
        }
    }


    /**
     * 验证用户是否登录，并获取用户id
     * @param req
     * @return
     */
    public String getUserId(HttpServletRequest req){
        //从请求头里面获取token
        try{
            //String token = req.getHeader("UserToken");
            String token = req.getParameter("UserToken");
            System.out.println("从请求头里面获取到的token----------->"+token);
            if(token == null){
                return null;
            }else{
                //用token去找redis中的用户信息
                WwqUser user = (WwqUser) manager.get(token);
                String id = user.getId();
                return id;
            }
        }catch(Exception e){
            return null;
        }
    }


    /**
     * 保存图片验证码
     * @param code
     * @param codeKey
     * @return
     */
    public boolean setCaptcha(String code,String codeKey){
        Boolean b = manager.set(codeKey, code,60000L);
        return b;

    }

    /**
     * 获取图片redis中的图片验证码
     * @param codeKey
     * @return
     */
    public String getCaptcha(String codeKey){
        String code = (String) manager.get(codeKey);
        return code;
    }


    public boolean del(String key){
        manager.remove(key);
        return true;
    }

}
