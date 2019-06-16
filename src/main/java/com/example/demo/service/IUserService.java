package com.example.demo.service;

import com.example.demo.entity.UserEntity;

public interface IUserService {

    // 用户登录
    public UserEntity login(UserEntity userEntity);
    // 用户注册
    public UserEntity register(UserEntity userEntity);

}
