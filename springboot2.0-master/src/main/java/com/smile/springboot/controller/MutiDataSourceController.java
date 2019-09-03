package com.smile.springboot.controller;

import com.smile.springboot.service.UserService;
import com.smile.springboot.service2.UserService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MutiDataSourceController {

    @Autowired
    @Qualifier(value = "item1Service")
    private UserService userService1;

    @Autowired
    @Qualifier(value = "item2Service")
    private UserService2 userService2;

    @RequestMapping("insertUserDB1/{userName}/{password}")
    public String insertUserDB1(@PathVariable String userName, @PathVariable String password){
        int result = userService1.insertUser(userName, password);
        if(result>0)return "成功插入数据库1";
        else return "插入数据库1失败……";
    }

    @RequestMapping("insertUserDB2/{userName}/{password}")
    public String insertUserDB2(@PathVariable String userName, @PathVariable String password){
        int result = userService2.insertUser(userName, password);
        if(result>0)return "成功插入数据库2";
        else return "插入数据库2失败……";
    }

    @RequestMapping("insertUserDB1AndDB2/{userName}/{password}")
    public String insertUserDB1AndDB2(@PathVariable String userName, @PathVariable String password){
        int result = userService1.insertUserDB1AndDB2(userName, password);
        if(result>0)return "成功插入数据库1和数据库2";
        else return "插入数据库1和数据库2失败……";
    }

}
