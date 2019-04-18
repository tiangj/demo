package com.example.wwq.controller;


import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.example.wwq.entity.WwqUser;
import com.example.wwq.kit.*;
import com.example.wwq.service.IWwqUserService;
import com.example.wwq.service.IWwqUserShareAmountDetailService;
import com.example.wwq.service.IWwqUserShareAmountService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
@Controller
@RequestMapping("/wwqUser")
public class WwqUserController {


        @Autowired
        private WxLoginHelper wxLoginHelper;

        @Autowired
        private AuthorHelper authorHelper;

        @Autowired
        private IWwqUserService wwqUserService;

        @Autowired
        private SMSKit smsKit;

        @Autowired
        private IWwqUserShareAmountService wwqUserShareAmountService;

        @Autowired
        private IWwqUserShareAmountDetailService wwqUserShareAmountDetailService;


        /**
         * 微信授权
         * @param req
         * @param resp
         * @return
         * @throws IOException
         */
        @SuppressWarnings("deprecation")
        @RequestMapping("/weLogin")
        @ResponseBody
        public String wxChat(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            /**
             * 1、获取返回的回调地址
             * 2、http://636.hnguwei.com是当前的外网地址
             * */
            //授权之前判断用户是否已经授过权，然后是否完善手机号码，
            // 如果授权但未完善手机号，跳转完善手机号界面，如果未授权，直接拉取授权
            String returnURl = "http://admin.wanwuquanhn.com/demo/wwqUser/wxCallBack";
            //第一步：用户同意授权，获取code
            String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WeCahtUtils.APPID
                    + "&redirect_uri=" + URLEncoder.encode(returnURl)
                    + "&response_type=code"
                    + "&scope=snsapi_userinfo"
                    + "&state=STATE#wechat_redirect";
            //进行重定向
            resp.sendRedirect(url);
            return null;
        }



        /*
         * ram resp
         * @param code
         * @throws ClientProtocolException
         * @throws IOException
         */
        @RequestMapping(value="/wxCallBack",produces="text/html;charset=UTF-8")
        @ResponseBody
        public void callBack(HttpServletResponse resp,String code) throws ClientProtocolException,
                IOException {
            String access_token;
            String openid;
            System.out.println("code:"+code);
            boolean b = wxLoginHelper.getCode(code);
            if(b){
                //已授权的情况
                String userInfo = wxLoginHelper.getUserInfo(code).toString();
                System.out.println("userInfo:----------->"+userInfo);
                JSONObject jsonObject = JSONObject.fromObject(userInfo);
                access_token = jsonObject.getString("access_token");
                openid = jsonObject.getString("openid");
                //根据openId获取用户手机号
                List<Map<String,Object>> userInfoList = wwqUserService.selectUserInfo(openid);
                if(userInfoList == null || userInfoList.size() < 1){
                    System.out.println("1");
                    resp.sendRedirect("http://www.wanwuquanhn.com/login");
                }else if(StringUtils.isBlank(userInfoList.get(0).get("phone").toString())){
                    System.out.println("1-1");
                    //List<Map<String, Object>> userList = (List<Map<String, Object>>) userInfoList.get(0).get("userList1");
                    String userToken = authorHelper.setSession(userInfoList.get(0));
                    System.out.println("1-2");
                    resp.sendRedirect("http://www.wanwuquanhn.com/?token="+userToken);
                }
            }else{
                //未授权的情况
                // 请求方法 和参数
                System.out.println("q");
                String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
                        + WeCahtUtils.APPID + "&secret=" + WeCahtUtils.APPSECRET
                        + "&code=" + code + "&grant_type=authorization_code";
                System.out.println("q.");
                JSONObject jsonObject = WeCahtUtils.getJSONObject(url);
                System.out.println("q10");
                wxLoginHelper.setUserInfo(code, jsonObject.toString());
                System.out.println("q11");
                access_token = jsonObject.getString("access_token");
                System.out.println("q12");
                openid = jsonObject.getString("openid");
                System.out.println("q13");
            }
            //根据openId获取用户手机号
            List<Map<String,Object>> userInfoList = wwqUserService.selectUserInfo(openid);
            System.out.println("q1");
            if(userInfoList == null || userInfoList.size() < 1){
                // 4 第四步：拉取用户信息(需scope为 snsapi_userinfo)
                System.out.println("q2");
                String returnUrl = "https://api.weixin.qq.com/sns/userinfo?access_token="
                        + access_token + "&openid=" + openid + "&lang=zh_CN";
                System.out.println("q3");
                JSONObject userInfo = WeCahtUtils.getJSONObject(returnUrl);
                System.out.println("q4");
                Map<String, Object> retMap = wwqUserService.saveUserInfo(userInfo);
                System.out.println("q5");
                System.out.println("retMap =====" +userInfo);
                //控制页面跳转
                if (retMap == null || retMap.size() < 1) {
                    System.out.println("q6");
                    resp.sendRedirect("http://www.wanwuquanhn.com/login");
                } else {
                    if(Integer.parseInt(retMap.get("code").toString()) == 200){
                        System.out.println("q7");
                        List<Map<String, Object>> userList = (List<Map<String, Object>>) retMap.get("userList1");
                        System.out.println("q14");
                        String userToken = authorHelper.setSession(userList.get(0));
                        System.out.println("q15");
                        resp.sendRedirect("http://www.wanwuquanhn.com/?token="+userToken);
                        System.out.println("q16");
                    }else{
                        System.out.println("q17");
                        // 得到用户id
                        @SuppressWarnings("unchecked")
                        List<Map<String, Object>> userList = (List<Map<String, Object>>) retMap.get("userList1");
                        System.out.println("q18");
                        // 生成token
                        String token = authorHelper.setSession(userList.get(0));
                        System.out.println("q19");
                        resp.sendRedirect("http://www.wanwuquanhn.com/login?token="+token);
                    }
                }
            }else if(!StringUtils.isBlank(userInfoList.get(0).get("phone").toString())){
                System.out.println("2");
                String userToken = authorHelper.setSession(userInfoList.get(0));
                System.out.println("q18");
                resp.sendRedirect("http://www.wanwuquanhn.com/?token="+userToken);
            }else{
                System.out.println("3");
                resp.sendRedirect("http://www.wanwuquanhn.com/login");
            }

        }


    /**
     * 图片验证码
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/captchaUtil",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getCaptchaUtil(HttpServletResponse resp) throws IOException{
        Map<String, Object> map = ValidateCode.generateImageCode(4, 4, null, 90, 30, 0, false, null, new Color(59, 162, 9), null);
        String codeKey = java.util.UUID.randomUUID().toString().replaceAll("-", "");
        authorHelper.setCaptcha(map.get("textCode").toString(), codeKey);
        Map<String, Object> retMap = new HashMap<String, Object>();
        retMap.put("code", map.get("textCode"));
        retMap.put("codeKey", codeKey);
        retMap.put("bim", "data:image/jpg;base64,"+map.get("bufferedImage"));
        return JSONResult.init(200, "success",retMap);
    }


    /**
     * 发送短信验证码
     * @param phone
     * @param code
     * @param codeKey
     * @return
     */
    @RequestMapping(value="/sendMsg",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String sendMsg(String phone,String code,String codeKey){
        String redisCode = authorHelper.getCaptcha(codeKey);
        if(redisCode == null){
            return JSONResult.init(501, "图片验证码错误！");
        }
        if(!redisCode.equals(code)){
            return JSONResult.init(501, "图片验证码错误！");
        }
        String phoneCode = ValidateCode.generateTextCode(0, 6, null);
        try {
            @SuppressWarnings("static-access")
            SendSmsResponse response = smsKit.sendSms(phone, phoneCode);
            if(response == null){
                return JSONResult.init(500, "短信发送失败！");
            }
            if(!response.getCode().equals("OK")){
                return JSONResult.init(500, "短信发送失败！");
            }
        } catch (ClientException e) {
            e.printStackTrace();
            return JSONResult.init(500, "短信发送失败！");
        }
        //保存短信验证码到redis
        String smsCode = java.util.UUID.randomUUID().toString().replaceAll("-", "");
        authorHelper.setCaptcha(phoneCode, smsCode);
        Map<String, String> retMap = new HashMap<String, String>();
        retMap.put("code", phoneCode);
        retMap.put("smsCode", smsCode);
        return JSONResult.init(200, "success",retMap);
    }


    /**
     * 注册
     * @param phone
     * @param code
     * @param smsCode
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/regist",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String regist(HttpServletRequest req,String phone,String code,String smsCode) throws IOException{
        String smsRedisCode = authorHelper.getCaptcha(smsCode);
        if(smsRedisCode == null){
            return JSONResult.init(501, "短信验证码错误！");
        }
        if(!smsRedisCode.equals(code)){
            return JSONResult.init(501, "短信验证码错误！");
        }
        String userId = authorHelper.getUserId(req);
        if(userId == null){
            return JSONResult.init(301, "用户未授权!");
        }
        //保存手机号到数据库以及微信永久二维码
        boolean b = wwqUserService.updateUserPhone(phone, userId);

        if(b){
            //获取用户信息
           Map<String,Object> retList = wwqUserService.selectUserInfo1(userId);
            if (retList == null || retList.size() < 1) {
                return JSONResult.init(500, "手机号绑定失败!");
            } else {
                // 生成token
                String token = authorHelper.setSession(retList);
//				retList.get(0).put("token", token);
                return JSONResult.init(200, "success!",token);
            }
        }else{
            return JSONResult.init(500, "信息验证有误！");
        }
    }


    /**
     * 退出登录
     * @return
     */
    public String loginOut(HttpServletRequest req){
        String token = req.getHeader("UserToken");
        if(token == null){
            return JSONResult.init(300, "用户未登录！");
        }
        boolean b = authorHelper.del(token);
        if(b){
            return JSONResult.init(200, "success",b);
        }else{
            return JSONResult.init(500, "fails",b);
        }
    }



    /**
     * 用户信息
     * @param req
     * @return
     */
    @RequestMapping(value="/userInfo",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String userInfo(HttpServletRequest req){
        String userId = authorHelper.getUserId(req);
        if(userId == null){
            return JSONResult.init(301, "用户未登录!");
        }
        Map<String,Object> user = wwqUserService.selectUserInfo1(userId);
        if(user == null){
            return JSONResult.init(301, "用户未登录！");
        }
        return JSONResult.init(200, "success",user);
    }


    /**
     * 用户扫码关注列表
     * @param req
     * @return
     */
    @RequestMapping(value="/userConcatList",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String userConcatList(HttpServletRequest req, Integer pageNum, Integer pageSize){
        String userId = authorHelper.getUserId(req);
        if(userId == null){
           return JSONResult.init(301,"用户未登录");
        }
//        String userId = "2df0802ede2444bbb939e3691be66a43";
        PageInfo<Map<String, Object>> retList = wwqUserService.userConcatList(userId, pageNum, pageSize);
        if(retList == null || retList.getList().size()<1){
            return JSONResult.init(500,"数据为空");
        }else{
            return JSONResult.init(200,"success",retList);
        }
    }


    /**
     * 用户分销总额
     * @param req
     * @return
     */
    @RequestMapping(value="/userShareCountAmount",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String userShareCountAmount(HttpServletRequest req){
        //String userId = "0915364a8b014a7da90e37fca8fec225";
        String userId = authorHelper.getUserId(req);
        if(userId == null){
            return JSONResult.init(301,"用户未登录！");
        }
        Map<String,Object> map = wwqUserShareAmountService.userShareCountAmount(userId);
        if(map == null || map.size()<1) {
            return JSONResult.init(500, "当前用户不存在！");
        }else{
            return JSONResult.init(200,"success",map);
        }
    }

    /**
     * 用户分销佣金明细，包含提现明细
     * @param req
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/userShareCountAmountDetail",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String userShareCountAmountDetail(HttpServletRequest req, Integer pageNum, Integer pageSize){
        //String userId = "9c63c2d6c2cc4db1bff2287346c0092d";
        String userId = authorHelper.getUserId(req);
        if(userId == null){
            return JSONResult.init(301,"用户未登录！");
        }
        PageInfo<Map<String,Object>> pageInfo = wwqUserShareAmountDetailService.userShareCountAmountDetail(userId,pageNum,pageSize);
        if(pageInfo == null || pageInfo.getList().size()<1){
            return JSONResult.init(500,"数据为空");
        }else{
            return JSONResult.init(200,"success",pageInfo);
        }
    }

}

