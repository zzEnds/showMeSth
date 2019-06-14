package com.example.demo.mapper;

import com.example.demo.entity.UserEntity;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {

    @Results({
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password")
    })

    @Select("select username, password from userinfo where username = #{username} and password = #{password}")
    List<UserEntity> selectOneUser(UserEntity userEntity);

}
