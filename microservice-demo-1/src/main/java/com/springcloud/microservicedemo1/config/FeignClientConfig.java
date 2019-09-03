package com.springcloud.microservicedemo1.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//这个接口不应该写在服务调用方，应该写在服务提供方
//服务提供方写好接口，使用mvn clean install放在仓库中，由服务调用方引入
//下面这个接口就会访问"MICROSERVICE-CLIENT"这个服务的"/productList"这个接口

@FeignClient(value = "MICROSERVICE-CLIENT")
public interface FeignClientConfig {

    @GetMapping("/productList")
    public String getProductList();
}
