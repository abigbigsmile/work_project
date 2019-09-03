package com.springcloud.microservicedemo1.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

    @Autowired
    private RestTemplate restTemplate;

    //从microservice-demo-2获取服务，当发生异常，Hystrix适用调用fallback方法
    //@HystrixCommand(fallbackMethod = "fallback")
    //下面的诸多属性处于写死的状态，可以写在配置文件上
    @RequestMapping("/testHystrix")
    @HystrixCommand(commandProperties = {
            //下面设置请求服务的超时时间为3秒，超过3秒将会进入fallback
            //@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            //请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            //休眠窗口值
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            //打开断路器的失败次数百分比
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")

    })
    public String testHystrix(@RequestParam(name = "num") Integer num){
        if(num%2 == 0 ){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return restTemplate.getForObject("http://SERVICE-SUPLY/productList", String.class);
    }

    private String fallback(){
        return "访问量太大了，请求支援！！！";
    }

    private String defaultFallback(){
        return "默认提示：访问量太大了，请求支援！！！";
    }



}
