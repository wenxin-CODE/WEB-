package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void test(){
        //获取sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方法1
        // getMapper：UserMapper相当于UserDao的实现类，
        // 使用UserDao接口来创建对象，再调用对象的方法
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> userList = mapper.getUserList();

        //方法2
//        List<User> userList = sqlSession.selectList("com.kuang.dao.UserDao.getUserList");
        for (User user : userList) {
            System.out.println(user.toString());
            System.out.print(user.getId());
            System.out.print(user.getName());
            System.out.println(user.getPwd());
        }

        //关闭
        sqlSession.close();

    }
}
