package com.smile.springboot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smile.springboot.exception.JdbcException;
import com.smile.springboot.mapper.UserMapper;
import com.smile.springboot.mapper2.UserMapper2;
import com.smile.springboot.model.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "item1Service")
@Slf4j
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserMapper2 userMapper2;

    //事务
    //@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = RuntimeException.class,transactionManager = "item1TransactionManager")
    public int insertUser(String userName, String password){
        int insertUserResult = userMapper.insertUser(userName,password);
        log.info("########insertUserResult:{}##########",insertUserResult);
        return insertUserResult;
    }
    public User findUserById(Integer userId) throws Exception{
        User user = userMapper.findUserById(1);
        if(user != null)log.info("#######sucess finding a user#########");
        return user;
    }

    //当同时操作两个数据库时，但是此时也拥有两个事务，存在异常回滚问题，此时需要分布事务管理
    //传统解决方案是jta+atomikos:原理为2pc.
    //    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = RuntimeException.class)
    @Transactional
    public int insertUserDB1AndDB2(String userName, String password){
        int result1 = userMapper.insertUser(userName,password);
        int result2 = userMapper2.insertUser(userName,password);
        //int i = 2/0;
        return result1+result2;
    }


    public PageInfo<User> getUserListPage(int pageNum, int pageSize){
        //启动PageHelper,实现原理是：aop——修改查询的sql语句
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userMapper.getUserList();
        PageInfo<User> userPage = new PageInfo<>(userList);
        return userPage;
    }


}
