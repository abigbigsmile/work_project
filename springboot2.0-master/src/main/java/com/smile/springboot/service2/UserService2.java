package com.smile.springboot.service2;

import com.smile.springboot.exception.JdbcException;
import com.smile.springboot.mapper2.UserMapper2;
import com.smile.springboot.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


//测试多数据源
@Service(value = "item2Service")
@Slf4j
public class UserService2 {

    @Autowired
    @Qualifier("userMapper2")
    private UserMapper2 userMapper;

    //事务
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = RuntimeException.class,transactionManager = "item2TransactionManager")
    public int insertUser(String userName, String password){
        int insertUserResult = userMapper.insertUser(userName,password);
        if(true)throw new JdbcException();
        log.info("########insertUserResult:{}##########",insertUserResult);
        return insertUserResult;
    }
    public User findUserById(Integer userId) throws Exception{
        User user = userMapper.findUserById(1);
        if(user != null)log.info("#######sucess finding a user#########");
        return user;
    }

}
