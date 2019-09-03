package com.smile.springboot.controller;

import com.github.pagehelper.PageInfo;
import com.smile.springboot.model.User;
import com.smile.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("insertUser/{userName}/{password}")
    public String insertUser(@PathVariable String userName, @PathVariable String password){
        int result = userService.insertUser(userName, password);
        if(result>0)return "成功插入数据库！！";
        else return "插入数据库失败……";
    }

    @RequestMapping("findUser/{userId}")
    public User findUser(@PathVariable(name = "userId", required = true) Integer userId) throws Exception{
        return userService.findUserById(userId);
    }

    @RequestMapping("getUserPage/{pageNum}/{pageSize}")
    public PageInfo<User> getUserPage(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        PageInfo<User> userPage = userService.getUserListPage(pageNum, pageSize);
        return userPage;
    }
}
