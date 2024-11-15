package com.cdd.controller;

import com.cdd.biz.BookBiz;
import com.cdd.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BookController {
    @Autowired
    private BookBiz biz;

    @RequestMapping("/book/list")
    public Map findBooks(){
        List<Book> list = biz.findAll();

        Map result = new HashMap<>();
        result.put("isOk",true);
        result.put("msg","查询成功");
        result.put("books",list);
        return result;
    }
    @RequestMapping("/book/add")
    public Map add(Book book){
        this.biz.addBook(book);
        Map result = new HashMap<>();
        result.put("isOk",true);
        result.put("msg","添加");
        return result;
    }
    @RequestMapping("/book/del")
    public Map del(int id){

        Map result = new HashMap<>();
        if(this.biz.delBook(id)){
            result.put("isOk",true);
            result.put("msg","删除成功");
        }else{
            result.put("isOk",false);
            result.put("msg","删除失败");
        }

        return result;
    }

    @RequestMapping("/book/update")
    public Map update(Book book){
        Map result=new HashMap<>();
        if(this.biz.updateBook(book)){
            result.put("isOk",true);
            result.put("msg","编辑成功");
        }else{
            result.put("isOk",false);
            result.put("msg","编辑失败");
        }
        return result;
    }

    @RequestMapping("/book/que")
    public Map findById(int id) {
        List<Book> list=  biz.queBook(id);
        Map result = new HashMap<>();
        result.put("isOk", true);
        result.put("msg", "查询成功");
        result.put("books", list);
        return result;
    }


    public void setBiz(BookBiz biz) {
        this.biz = biz;
    }




}
