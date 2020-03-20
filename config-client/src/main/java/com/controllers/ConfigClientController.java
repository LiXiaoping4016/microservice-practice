package com.controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户端控制类
 *
 * @Author lixp23692
 * @Date 2019/9/2
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${testInfo}")
    private String testInfo;

    //  127.0.0.1:7002/actuator/refresh

    @RequestMapping("/getTestInfo")
    public String getTestInfo() {
        return testInfo;
    }
}
