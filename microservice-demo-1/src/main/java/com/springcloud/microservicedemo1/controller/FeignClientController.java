package com.springcloud.microservicedemo1.controller;

import com.springcloud.client.ProductClient;
import com.springcloud.common.ProductOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 使用Feign作为HTTP客户端进行服务调用，基于接口的注解
 */
@RestController
public class FeignClientController {

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getInfo")
    public List<ProductOutput> getInfo(){
        List<ProductOutput> productList = productClient.getProductList();
        return productList;
    }

    @GetMapping("callTestSleuth")
    public String callTestSleuth(){
        return productClient.sleuth();
    }



}
