package com.smile.springboot.mapper;

import com.smile.springboot.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Options(useGeneratedKeys = true, keyProperty = "user_id")//指定使用自增主键
    @Insert("insert into user(username,password) values(#{userName},#{password})")
    public int insertUser(@Param(value = "userName") String userName, @Param(value = "password")String password);

    @Results(
            id = "userResultMap",
            value = {
                    @Result(id = true, column = "user_id", property = "userId"),
                    @Result(column = "username", property = "userName"),
                    @Result(column = "password", property = "password")
            }
    )
    @Select("select * from user where user_id = #{userId}")
    public User findUserById(Integer userId) throws Exception;

    @Select("select * from user")
    @ResultMap(value = "userResultMap")
    public List<User> getUserList();

}
