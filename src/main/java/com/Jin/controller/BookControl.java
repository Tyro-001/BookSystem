package com.Jin.controller;

import com.Jin.pojo.Books;
import com.Jin.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("book")
public class BookControl {

    //controller 要实现方法，必须调用service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //查询所有书籍，并返回jsp
    @RequestMapping("/allBook")
    public String queryAll(Model model){
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("msg",list);
        System.out.println(list);
        return "allBook";
    }

    //跳转到添加页面
    @RequestMapping("/toAddBook")
    public String toAddBook(){
        return "addBook";
    }

    //添加此书籍
    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("addBook==>"+books);
        int i = bookService.addBook(books);
        if(i>0){
            System.out.println("添加成功！"+books);
        }
        return "redirect:/book/allBook";
    }

    //跳转到修改页面
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(int id,Model model){
        Books books = bookService.queryBook(id);
        model.addAttribute("book",books);
        return "updateBook";
    }

    //修改此书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        System.out.println("updateBook==>"+books);
        int i = bookService.updateBook(books);
        if(i>0){
            System.out.println("修改成功！"+books);
        }
        return "redirect:/book/allBook";
    }

    //删除此书籍
    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id){
        bookService.deleteBook(id);
        return "redirect:/book/allBook";
    }

    //搜索书籍
    @RequestMapping("queryBook")
    public String queryBook(String bookName,Model model){
        List<Books> books = bookService.queryBooksName(bookName);
        System.err.println("queryBooksName==>"+books);

        if (books.isEmpty()){
            System.out.println("测试没查到");
            model.addAttribute("errors","未查到");
        }
        else if (bookName.isEmpty()){
            System.out.println("测试List为空");
            model.addAttribute("errors","请输入索引");
        }
        model.addAttribute("msg",books);
        return "allBook";

    }

}
