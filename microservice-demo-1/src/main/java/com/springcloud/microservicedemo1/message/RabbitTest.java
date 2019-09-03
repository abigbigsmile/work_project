package com.springcloud.microservicedemo1.message;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitTest {

    //@RabbitListener(queues = "testQueue")//需要手动声明队列
    //@RabbitListener(queuesToDeclare = @Queue("testQueue")) //自动声明对垒

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("testQueue"),
            exchange = @Exchange("testExchange")
    ))
    public void  consumer(String message){
        log.info("message :" + message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("chinaQueue"),
            key = "china",
            exchange = @Exchange("myExchange")
    ))
    public void  chinaConsumer(String message){
        log.info("message :" + message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("americaQueue"),
            key = "america",
            exchange = @Exchange("myExchange")
    ))
    public void  amaricaConsumer(String message){
        log.info("message :" + message);
    }



}
