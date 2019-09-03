package com.springcloud.microservicedemo1.message;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RabbitTestTest {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send(){
        amqpTemplate.convertAndSend("testQueue", "time——" + new Date());
    }

    @Test
    public void sendToChina(){
        amqpTemplate.convertAndSend("chinaExchange", "china", "Huawei");
    }

    @Test
    public void sendToAmerica(){
        amqpTemplate.convertAndSend("americaExchange", "america", "Google");
    }
}