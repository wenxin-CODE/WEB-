package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void test(){
        //获取sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方法1
        // getMapper：UserMapper相当于UserDao的实现类，
        // 使用UserDao接口来创建对象，再调用对象的方法
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();

        //方法2
//        List<User> userList = sqlSession.selectList("com.com.kuang.dao.UserDao.getUserList");
        for (User user : userList) {
            System.out.println(user.toString());
            System.out.print(user.getId());
            System.out.print(user.getName());
            System.out.println(user.getPwd());
        }

        //关闭
        sqlSession.close();

    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //相当于new对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(3);
        System.out.println(user.toString());

        sqlSession.close();
    }

    @Test
    public void testLog4j(){
        logger.info("come info");
        logger.debug("come debug");
        logger.error("com errro");
    }

    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        map.put("startIndex",0);
        map.put("pageSize",3);
        List<User> userList = mapper.getUserByLimit(map);
        for(User user:userList){
            System.out.println(user);
        }

        sqlSession.close();
    }
}
