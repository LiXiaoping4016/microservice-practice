package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 分布式配置中心-服务端
 *
 * @Author lixp23692
 * @Date 2019/9/2
 */
@EnableConfigServer
@EnableEurekaClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AppConfigServerStarter {
    public static void main(String[] args) {
        SpringApplication.run(AppConfigServerStarter.class, args);
    }
}
