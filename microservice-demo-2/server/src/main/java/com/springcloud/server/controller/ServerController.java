package com.springcloud.server.controller;

import com.springcloud.common.ProductOutput;
import com.springcloud.server.model.Product;
import com.springcloud.server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//模拟两个微服务应用之间的通信
@RestController
public class ServerController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/productList")
    public List<ProductOutput> productList(){
        List<ProductOutput> productList = productService.productList();
        return productList;
    }

    @GetMapping(value = "/testSleuth")
    public String testSleuth(){
        return "use Sleuth to sleuth .";
    }

}
