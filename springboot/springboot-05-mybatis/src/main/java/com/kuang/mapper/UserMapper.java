package com.kuang.mapper;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//表明这是一个mybatis的mapper类
@Mapper
@Repository//另一种@Component
public interface UserMapper {

    List<User> queryUserList();

    User selectUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

}
