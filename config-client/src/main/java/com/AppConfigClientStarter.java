package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 分布式配置中心-客户端
 *
 * @Author lixp23692
 * @Date 2019/9/2
 */
@SpringBootApplication
@EnableEurekaClient
public class AppConfigClientStarter {
    public static void main(String[] args) {
        SpringApplication.run(AppConfigClientStarter.class, args);
    }
}
