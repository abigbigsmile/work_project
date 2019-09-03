package com.smile.springboot.controller;



import com.smile.springboot.exception.NotLoginException;
import com.smile.springboot.exception.NullOrEmptyException;
import com.smile.springboot.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@EnableAutoConfiguration
@EnableAsync
@Slf4j
public class TestController {

    @Autowired
    private TestService testService;

    @Value("${father}")
    private String prop1;

    @Value("${mother.son}")
    private String prop2;


    //获取配置文件设定的值
    @Value(value = "${http-url}")
    private String httpUrl;

    //获取日志记录器Logger，名字为本类类名
    //private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/hello/{error}")
    public String hello(@PathVariable(value = "error", required = false) Integer error) throws Exception{
        if(error == 0)throw new NotLoginException();
        if(error == 1)throw new NullOrEmptyException();
        if(error == 2)throw new RuntimeException();
        log.info("I'm use Log4j !");
        return "jsp/hello";
    }

    //测试@Async注解，需要@EnableAsync启动，注解的方法会新增线程异步执行
    @RequestMapping("/testAsync")
    public String testAsync(){
        String result;
        result = testService.testAsync();
        result = "in controller .";
        return result;
    }

    @RequestMapping("/multiEnvironment")
    public String multiEnvironment(){
        return httpUrl;
    }

    @RequestMapping("testHotDeploy")
    public String testHotDeploy(){
        String result = "a string : the chosen hello . ";
        return result;
    }

    @RequestMapping("testYML")
    public String testYML(){
        return prop1 + " and " + prop2;
    }

    @RequestMapping("testFunction")
    public String testFunction(){
        return "hello";
    }


}
