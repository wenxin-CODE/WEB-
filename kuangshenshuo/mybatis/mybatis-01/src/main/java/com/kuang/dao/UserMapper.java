package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;

public interface UserMapper {
    //查询全部用户
    List<User> getUserList();
    //根据id查询
    User getUserById(int id);
    //添加用户
    Integer addUser(User user);
    //修改用户
    Integer updateUser(User user);
    //删除用户
    int deleteUser(int id);
}
