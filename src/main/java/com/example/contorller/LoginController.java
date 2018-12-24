package com.example.contorller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tian on 2018/12/24.
 */
@Controller
@EnableAutoConfiguration
public class LoginController {

    @RequestMapping("/signIn")
    @ResponseBody
    public String signIn(String name,String password){
        System.out.println("123");
        return null;
    }

    @RequestMapping("/")
    public String toLogin(){
        return "login";
    }
}
