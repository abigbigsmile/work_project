package com.springcloud.microservicedemo1.controller;

import com.springcloud.microservicedemo1.model.Cat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class ZuulController {

    @RequestMapping(value = "/testZuul")
    public Cat testZuul(){
        return new Cat(88, "myLover");
    }

    /**
     * 配置zuul.routes.ignored-patternss使得禁止路由到一下路径
     * @return
     */
    @RequestMapping(value = "/testIgnore")
    public Cat testIgnore(){
        return new Cat(77, "isIgnored");
    }

    /**
     * 注意：如果没有配置sensitiveHeaders会接收不到Cookie
     * @param request
     */
    @RequestMapping(value = "/testCookie")
    public void testCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            log.info("cookie name : {}, cookie valur : {}", cookie.getName(),cookie.getValue());
        }
        log.info("cookie is over .");
    }

    /**
     * Zuul添加pre和post过滤器
     * @return
     */
    @RequestMapping(value = "/testZuulFiler")
    public Cat testZuulFiler(){
        return new Cat(200, "you have token");
    }
}
