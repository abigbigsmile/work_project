package com.springcloud.microservicedemo1.message;

import com.springcloud.microservicedemo1.model.Cat;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
@EnableBinding(value = {StreamClient.class})
public class StreamMessageReceiver {

    @StreamListener(value = StreamClient.INPUT)
    public void receive(Object message){
        log.info("message received : {}", message);
    }


 /*   @StreamListener(value = StreamClient.INPUT)
    @SendTo(value = StreamClient.OUTPUT2)//这个注解可以实现消息的回送
    public String receiveCat(Cat message){
        log.info("message received : {}", message);
        return "I'm sending a response .";
    }*/

    /*@StreamListener(value = StreamClient.OUTPUT2)
    public void responseReceiver(String message){
        log.info("response : " + message);
    }*/





}
