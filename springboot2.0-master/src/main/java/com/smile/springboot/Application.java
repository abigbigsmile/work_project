package com.smile.springboot;


import com.smile.springboot.configuration.DBProperties1;
import com.smile.springboot.configuration.DBproperties2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

//@EnableAutoConfiguration
//@ComponentScan(basePackages = {"com.smile.springboot"})
@EnableConfigurationProperties(value = {DBProperties1.class, DBproperties2.class})
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
