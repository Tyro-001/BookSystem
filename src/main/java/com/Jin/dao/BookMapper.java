package com.Jin.dao;

import com.Jin.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    //增加书
    int addBook(Books books);

    //删除
    int deleteBook(@Param("bookID") int id);

    //修改
    int updateBook(Books books);

    //查询某书
    Books queryBook(@Param("bookID") int id);

    //查询所有书
    List<Books> queryAllBook();

    //搜索书
    List<Books> queryBooksName(@Param("bookName") String bookName);
}
