package com.springcloud.microservicedemo1.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

import java.text.StringCharacterIterator;

//创建 StreamClient 接口，通过 @Input和 @Output注解定义输入通道和输出通道，
// 另外，@Input 和 @Output 注解都还有一个 value 属性，该属性可以用来设置消息通道的名称
public interface StreamClient {

    String INPUT = "inputChanel";
    String OUTPUT = "outputChanel";

    String INPUT2 = "input2Chanel";//定义另外一条接收通道，用于接收监听INPUT通道的消费者返回的相应信息
    String OUTPUT2 = "output2Chanel";
    /**
     * 当定义输出通道的时候，需要返回 MessageChannel 接口对象，该接口定义了向消息通道发送消息的方法；定义输入通道时，需要返回 SubscribableChannel 接口对象，该接口集成自 MessageChannel 接口，它定义了维护消息通道订阅者的方法
     *
     * @return
     */
    @Input(value = StreamClient.INPUT)
    SubscribableChannel input();

    @Output(value = StreamClient.OUTPUT)
    MessageChannel output();

    /*@Input(value = StreamClient.INPUT2)
    SubscribableChannel input2();

    @Output(value = StreamClient.OUTPUT2)
    MessageChannel output2();*/


}
