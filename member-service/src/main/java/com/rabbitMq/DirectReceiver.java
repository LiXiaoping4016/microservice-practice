package com.rabbitMq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * rabbitMq 消费者
 *
 * @Author lixp23692
 * @Date 2020.06.02
 */
@Component
@RabbitListener(queues = "TestDirectQueue")
public class DirectReceiver {
    @Value("${server.port}")
    private String serverPort;

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("###########消费者[" + serverPort + "]准备消费消息#########");
        System.out.println("DirectReceiver消费者收到消息  : " + testMessage.toString());
    }
}
