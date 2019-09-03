package com.springcloud.client;

import com.springcloud.common.ProductOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "service-suply")
public interface ProductClient {

    @GetMapping("/productList")
    List<ProductOutput> getProductList();

    @GetMapping("/testSleuth")
    String sleuth();

}
