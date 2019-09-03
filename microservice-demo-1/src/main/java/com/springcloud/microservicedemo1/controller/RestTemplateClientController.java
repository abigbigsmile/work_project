package com.springcloud.microservicedemo1.controller;

import com.netflix.discovery.converters.Auto;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateClientController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getFromServer")
    public String getFromServer(){
        RestTemplate restTemplate = new RestTemplate();
        //1、第一种方式
        //RestTemplate是一个http客户端，这里使用RestTemplate进行应用间通信，但是这样不灵活
        //url写死，在线上时，你可能不知道要调用服务所在服务器的ip
//        String response = restTemplate.getForObject("http://localhost:8081/getInfo", String.class);


        //2、第二种方式：适用于知道服务名称而不知道host和port的时候

        ServiceInstance serviceInstance = loadBalancerClient.choose("MICROSERVICE-CLIENT");
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        //String url = "http://"+host+":"+String.valueOf(port)+"/getInfo";
        String url = String.format("http://%s:%s", host, String.valueOf(port)) + "/getInfo";
        System.out.println(url);
        String response = restTemplate.getForObject(url, String.class);

        //3、第三种方式
        /*String response = restTemplate.getForObject("http://MICROSERVICE-SERVER/getInfo", String.class);
        System.out.println();
        System.out.println(response);
        */

        return response;

    }

}
