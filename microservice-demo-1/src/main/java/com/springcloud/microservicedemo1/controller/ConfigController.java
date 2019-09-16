package com.springcloud.microservicedemo1.controller;

import com.springcloud.microservicedemo1.config.PrefixConfig;
import com.springcloud.microservicedemo1.model.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {

    @Value("${env}")
    private String env ;

    @Autowired
    private PrefixConfig nbaStar;

    @GetMapping("/test")
    public String test(){
        return env;
    }

    @GetMapping("/myCat")
    public String nba(){
        return "name:" + nbaStar.getName() + "; champion:" + nbaStar.getChampion();
    }

}
