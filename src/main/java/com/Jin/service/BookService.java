package com.Jin.service;

import com.Jin.pojo.Books;
import java.util.List;

public interface BookService {

    //增加书
    int addBook(Books books);

    //删除
    int deleteBook(int id);

    //修改
    int updateBook(Books books);

    //查询某书
    Books queryBook(int id);

    //查询所有书
    List<Books> queryAllBook();

    //搜索书
    List<Books> queryBooksName(String bookName);
}
