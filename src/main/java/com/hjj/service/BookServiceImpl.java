package com.hjj.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hjj.dao.BookMapper;
import com.hjj.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    //调用dao层的操作，设置一个set接口，方便Spring管理
    @Autowired
    private BookMapper bookMapper;

   /* public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }*/

    public int addBook(Books book) {
        return bookMapper.addBook(book);
    }

    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    public Books queryBookByName(String bookName) {
        return bookMapper.queryBookByName(bookName);
    }

    public PageInfo<Books> getBooksByPage(int page, int pageSize) {
        //开启分页支持
        PageHelper.startPage(page,pageSize);
        List<Books> list = bookMapper.queryAllBook();
        PageInfo pageInfo = new PageInfo(list);
        return  pageInfo;
    }

}
