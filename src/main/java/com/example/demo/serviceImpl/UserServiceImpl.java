package com.example.demo.serviceImpl;

import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserEntity login(UserEntity userEntity) {

        List<UserEntity> userEntities = userMapper.selectOneUser(userEntity);
        if(CollectionUtils.isEmpty(userEntities)) {
            return null;
        } else {
            return userEntities.get(0);
        }
    }
}
