package com.hjj.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hjj.pojo.Books;
import com.hjj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {


    @Autowired
   /* @Qualifier("BookServiceImpl")*/
    private BookService bookService;

/*    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }*/

    @RequestMapping("/toAddBook")
    public String toAddPaper() {
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addPaper(Books books) {
        System.out.println(books);
        bookService.addBook(books);
        return "redirect:/book/allBook?page=1";
    }


    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model, int id) {
        Books books = bookService.queryBookById(id);
        System.out.println(books);
        model.addAttribute("book",books );
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Model model, Books book) {
        bookService.updateBook(book);
        return "redirect:/book/allBook?page=1";
    }


    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook?page=1";
    }

/*    @RequestMapping("/queryBook")
    public String queryBook(String bookName,Model model){
        Books books = bookService.queryBookByName(bookName);
        List<Books> list = new ArrayList<Books>();
        if (books == null){
            list = bookService.queryAllBook();
            model.addAttribute("error", "未查到");
        }

        list.add(books);
        model.addAttribute("list", list);
        return "allBook";
    }*/


    @RequestMapping("/queryBook")
    public String queryBook(String bookName,Model model){
        PageHelper.startPage(1,7);
        Books books = bookService.queryBookByName(bookName);
        List<Books> list = new ArrayList<Books>();
        list.add(books);
        if (books == null){
           list = bookService.queryAllBook();

            model.addAttribute("error", "未查到");
        }
            model.addAttribute("pageInfo", new PageInfo(list));

        return "allBook";

    }

    //分页
    @RequestMapping("/allBook")
    public String getBooksByPage(int page,Model model) {
        PageInfo<Books> pageInfo = bookService.getBooksByPage(page, 4);
        model.addAttribute("pageInfo",pageInfo);
        return "allBook";
    }
}

