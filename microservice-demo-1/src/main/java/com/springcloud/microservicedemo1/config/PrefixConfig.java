package com.springcloud.microservicedemo1.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

//学会使用前缀的配置，结合@RefreshScopeceshi
@Component
@ConfigurationProperties(prefix = "nba")
@Data
@RefreshScope
public class PrefixConfig {

    private String name;

    private int champion;
}
