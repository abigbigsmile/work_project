package com.springcloud.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 启动类
 * 注解为Eureka客户端
 * mapper扫描：基于java配置mapper，可以再mapper上加@mapper注解
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement //配置事务管理
@MapperScan(basePackages = "com.springcloud.server.mapper")
public class MicroserviceDemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceDemo2Application.class, args);
	}

}
