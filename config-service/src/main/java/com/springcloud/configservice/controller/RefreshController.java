package com.springcloud.configservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RefreshController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String configServiceName;

    @PostMapping("/refresh")
    public Object sync() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        restTemplate.postForObject(String.format("http://%s/actuator/bus-refresh", configServiceName),map, Object.class);
        map.put("code", 0);
        return map;
    }

}
