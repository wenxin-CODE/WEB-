package com.kuang.dao;

import com.kuang.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
//    增加一本书
    int addBook(Books books);

//    删除一本书
    int deleteBookById(@Param("bookID") int id);

//    修改一本书
    int updateBook(Books books);

//    查询
    Books queryBookById(@Param("bookID") int id);

//    查询全部
    List<Books> queryAllBook();

//    按书名查询
    Books queryBookByName(@Param("bookName") String bookName);
}
