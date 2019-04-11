package com.example.wwq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Controller
@RequestMapping("/")
public class wxLoginSSOComtroller {

    @RequestMapping({"MP_verify_pbtT7TDiuPeXb2Lz.txt"})
    @ResponseBody
    private String returnConfigFile(HttpServletResponse response) throws IOException {
        //响应消息
        PrintWriter out = response.getWriter();
        out.print("pbtT7TDiuPeXb2Lz");
        out.flush();
        out.close();
        return null;
    }
}
