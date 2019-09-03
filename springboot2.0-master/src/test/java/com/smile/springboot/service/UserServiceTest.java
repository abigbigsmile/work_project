package com.smile.springboot.service;

import com.github.pagehelper.PageInfo;
import com.smile.springboot.Application;
import com.smile.springboot.mapper.UserMapper;
import com.smile.springboot.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    @Qualifier(value = "item1Service")
    private UserService userService;

    @Test
    public void insertUser() {
        for(int i=0; i<10; i++){
            userService.insertUser("name-"+i, "pass-"+i);
        }
    }

    @Test
    public void testPageHelper(){
        PageInfo<User> userPage = userService.getUserListPage(2,3);
        System.out.println(userPage);
    }
}