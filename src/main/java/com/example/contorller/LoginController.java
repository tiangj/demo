package com.example.contorller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.config.ConstantUtil;
import com.example.sys.entity.SysUser;
import com.example.sys.service.ISysUserService;
import com.example.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tian on 2018/12/24.
 */
@Controller
@EnableAutoConfiguration
public class LoginController {

    @Autowired
    private ISysUserService sysUserService;

    /****
     * 登录
     * @param name
     * @param password
     * @return
     */
    @RequestMapping("/signIn")
    @ResponseBody
    public Map<String,Object> signIn(String name,String password,HttpServletRequest request){
        EntityWrapper<SysUser> sysUserEntityWrapper=new EntityWrapper<>();
        sysUserEntityWrapper.eq("login_name",name);
        password=MD5Util.encodeBase64(password)+"";
        sysUserEntityWrapper.eq("password",password);
        sysUserEntityWrapper.eq("del_flag",0);
        SysUser sysUser=sysUserService.selectOne(sysUserEntityWrapper);

        Map<String,Object> result=new HashMap<>();
        if(sysUser!=null){
            HttpSession session = request.getSession();
            session.setAttribute(ConstantUtil.SEESION_USER_ID,sysUser.getId());
            session.setAttribute(ConstantUtil.SESSION_USER_NAME,sysUser.getName());
            //session.setMaxInactiveInterval(3000);
            result.put("code",1);
            result.put("msg","登录成功...");
        }else{
            result.put("code",0);
            result.put("msg","用户名或者密码不正确...");
        }
        return result;
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    @RequestMapping("/")
    public String toLogin(){
        return "login";
    }

}
