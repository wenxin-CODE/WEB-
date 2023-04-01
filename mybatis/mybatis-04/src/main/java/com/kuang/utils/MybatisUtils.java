package com.kuang.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//sqlSessionFactory-->sqlSession
public class MybatisUtils {

    public static SqlSessionFactory sqlSessionFactory;

    //初始即加载
    static {
        try {
            //第一步：获取sqlsession对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    //既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例。
    // SqlSession 提供了在数据库执行 SQL 命令所需的所有方法

    //创建对象
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession(true);
        //opensession参数autocommit设为true，后续自动提交
    }

    public static SqlSession getSession(boolean flag){
        return sqlSessionFactory.openSession(flag);
    }
}
