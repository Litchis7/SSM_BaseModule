package com.hjj.dao;

import com.hjj.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    //增加一个Book
    int addBook(Books book);

    //根据id删除一个Book
    //当你不使用@Param注解来声明参数时，必须使用使用 #{}方式。
    //不使用@Param注解时，参数只能有一个，并且是Javabean。在SQL语句里可以引用JavaBean的属性，而且只能引用JavaBean的属性。如果使用 ${} 的方式，会报错。
    int deleteBookById(@Param("bookID") int id);

    //更新Book
    int updateBook(Books books);

    //根据id查询,返回一个Book
    Books queryBookById(@Param("bookID") int id);

    //查询全部Book,返回list集合
    List<Books> queryAllBook();

    //根据书名查询Book，返回一个Book
    Books queryBookByName(@Param("bookName") String bookName);
}
