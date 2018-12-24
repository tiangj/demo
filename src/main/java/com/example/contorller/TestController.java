package com.example.contorller;

import com.example.entity.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tian on 2018/12/24.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/test")
public class TestController {

    @RequestMapping("getuser")
    public User getUser() {
        User user = new User();
        user.setName("test1");
        return user;
    }
}
