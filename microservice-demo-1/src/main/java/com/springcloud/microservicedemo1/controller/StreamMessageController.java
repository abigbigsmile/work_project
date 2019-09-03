package com.springcloud.microservicedemo1.controller;

import com.springcloud.microservicedemo1.message.StreamClient;
import com.springcloud.microservicedemo1.model.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/streamMessage")
public class StreamMessageController {

    @Autowired
    StreamClient streamClient;

    @GetMapping("/send")
    public void send(){
        Message message = MessageBuilder.withPayload("Today is " + new Date()).build();
        streamClient.output().send(message);
    }

    @GetMapping("/sendCat")
    public boolean sendCat(){
        Message message = MessageBuilder.withPayload(new Cat(20, "mimi")).build();
        return streamClient.output().send(message);
    }
}
