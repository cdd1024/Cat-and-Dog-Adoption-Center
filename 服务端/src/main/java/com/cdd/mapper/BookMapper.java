package com.cdd.mapper;

import com.cdd.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface BookMapper {
    @Select("select * from t_book")
    List<Book> selectBooks();
    @Select("select * from t_book where bookid=#{id}")
    List<Book> selectBookById(int id);
    @Insert("insert into t_book values(null,#{title},#{price},#{desc})")
    void insertBook(Book book);
    @Delete("delete from t_book where bookid=#{id}")
    int deleteBookById(int id);

    @Update("update t_book set title=#{title}, price=#{price}, `desc`=#{desc} where bookId=#{bookId}")
    int updateBook(Book book);



}
