package com;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 订单启动类
 *
 * @Author lixp23692
 * @Date 2019/8/27
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@EnableSwagger2Doc
public class AppOrderStarter {
    public static void main(String[] args) {
        SpringApplication.run(AppOrderStarter.class, args);
    }
}