package com.ddp.demo.dao;

import com.ddp.demo.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("SELECT * FROM user")
    List<User> queryUserInfo();
}
