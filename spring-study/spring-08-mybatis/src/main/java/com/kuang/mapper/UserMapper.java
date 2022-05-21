package com.kuang.mapper;

import com.kuang.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectUser();

    //添加一个用户
    int addUser(User user);

    //根据id删除用户
    int deleteUser(int id);
}
