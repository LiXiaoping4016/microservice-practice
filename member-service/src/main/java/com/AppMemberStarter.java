package com;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 会员服务启动类
 *
 * @Author lixp23692
 * @Date 2019/8/30
 */
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2Doc
public class AppMemberStarter {
    public static void main(String[] args) {
        SpringApplication.run(AppMemberStarter.class, args);
    }
}
