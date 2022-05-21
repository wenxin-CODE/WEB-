package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class UserDaoTest {

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
        User user = mapper.getUserById(1);
        System.out.println(user.toString());

        sqlSession.close();
    }

    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //相当于new对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int result = mapper.addUser(new User(4, "haha", "521"));

        if (result>0){
            System.out.println("success");
        }
        //------------提交事务------------
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //相当于new对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateUser(new User(3,"hehe","7758521"));
        //------------提交事务------------
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //相当于new对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int i = mapper.deleteUser(4);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //相当于new对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String,Object> map = new HashMap<>();
        map.put("userid",5);
        map.put("username","aaaaaaa");
        map.put("userpwd",2222223);
        int result = mapper.addUser2(map);

        if (result>0){
            System.out.println("success");
        }
        //------------提交事务------------
        sqlSession.commit();
        sqlSession.close();
    }

}
