package com.Jin.service;

import com.Jin.dao.BookMapper;
import com.Jin.pojo.Books;
import java.util.List;

public class BookServiceImpl implements BookService{

    //业务层实质：service调用dao层
    private BookMapper bookMapper;
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    @Override
    public int deleteBook(int id) {
        return bookMapper.deleteBook(id);
    }

    @Override
    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    @Override
    public Books queryBook(int id) {
        return bookMapper.queryBook(id);
    }

    @Override
    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    @Override
    public List<Books> queryBooksName(String bookName) {
        return bookMapper.queryBooksName(bookName);
    }
}
