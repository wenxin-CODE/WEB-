package com.kuang.dao;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    @Select("select * from user")
    List<User> getUser();

    @Select("select * from user where id=#{id}")
    User getUserById(@Param("id") int id);
    //多个参数用Param，sql语句对应的是param里的参数，他们名称要一致
    //param一般用于基本类型，引用类型比如对象就不要了

    @Insert("insert into user(id,name,pwd) values (#{id},#{name},#{pwd})")
    int addUser(User user);

    @Update("update user set name = #{name} where id = #{id}")
    int updatwUser(User user);
}
