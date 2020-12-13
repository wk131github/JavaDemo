package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author walkinger
 * @version 1.0
 * @date 2020/12/13 22:41
 */
@Controller
public class HelloController {
    @RequestMapping("/hello")
    @ResponseBody
    public String helloSpringBoot(){
        return "Hello,SpringBoot";
    }
}
