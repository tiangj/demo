package com.example.contorller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tian on 2018/12/24.
 */
@Controller
@EnableAutoConfiguration
public class LoginController {

    @RequestMapping("/signIn")
    @ResponseBody
    public String signIn(String name,String password){
        return "1";
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
