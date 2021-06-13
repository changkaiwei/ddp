package com.ddp.demo.service;

import com.ddp.demo.dao.UserMapper;
import com.ddp.demo.entity.User;
import com.ddp.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> queryUserInfo() {
        return userMapper.queryUserInfo();
    }
}
