package com.dly.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dly.springboot.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

//@Mapper  //相当于一个component,注入到beans里面
public interface UserMapper extends BaseMapper<User> {

//    继承BaseMapper就要注释掉下面的代码，以免同名冲突，BaseMapper都已经实现好了

//    @Select("select * from sys_user")
//    List<User> findAll();
//
//    @Insert("insert into sys_user(username,password,nickname,email,phone,address) " +
//            "VALUES (#{username},#{password},#{nickname},#{email},#{phone},#{address})")  //#{}表示是动态数据，可以吧下面的参数塞进去
//    int insert(User user);
////    这里执行成功后，为什么返回1
//
//
////    @Update("update sys_user set username = #{username},password = #{password},nickname = #{nickname}," +
////            "email = #{email},phone = #{phone},address = #{address} where id = #{id}")
////    上面这个是静态的修改，静态的是一改全改。动态修改用mybatis.xml文件
//    int update(User user);
//
//    @Delete("delete from sys_user where id = #{id}")
//    Integer deleteById(@Param("id") Integer id);
//    //    @Param指定名称，和sql语句中的#{id}对应，可以和方法的参数id不一样
//
//    @Select("select * from sys_user where username like concat('%',#{username},'%') and email like concat('%',#{email},'%') limit #{pageNum}, #{pageSize}")
//    List<User> selectPage(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize,
//                          @Param("username") String username, @Param("email") String email);
//
//    @Select("select count(*) from sys_user where username like concat('%',#{username},'%') and email like concat('%',#{email},'%')")
//    Integer selectTotal(@Param("username") String username, @Param("email") String email);
////    MyBatis中不允许直接传递多个数据,如果是多值需要转化为单值————加@Param(“XXX”)起别名
}
