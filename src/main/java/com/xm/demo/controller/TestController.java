package com.xm.demo.controller;

import com.xm.demo.config.WeChatConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("test")
    public String test() {
        System.out.println("hello springBoot!");
        return "hello springBoot111!";
    }

    @Autowired
    private WeChatConfig weChatConfig;

    @RequestMapping("testConfig")
    public String testConfig() {
        System.out.println(weChatConfig.getAppId());
        System.out.println(tfig());
        return weChatConfig.getAppSecret();
    }

    public String tfig() {
        return "1111";
    }

}
