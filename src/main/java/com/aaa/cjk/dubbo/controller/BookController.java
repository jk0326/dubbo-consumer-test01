package com.aaa.cjk.dubbo.controller;

import com.aaa.cjk.dubbo.model.Book;
import com.aaa.cjk.dubbo.service.IBookService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author 陈佳康
 * @date 2019-09-06 19:17
 * 处理图书信息相关的控制器
 */
@Controller
public class BookController {

    @Reference
    private IBookService bookService;

    /**
    * @author  陈佳康
    * @description 异步图书信息传到前台
    */
    @RequestMapping("/getAllBook")
    @ResponseBody
    public Map<String,Object> getaAllBook(){
        return bookService.getAllBooks();
    }

    /**
    * @author  陈佳康
    * @description 跳转到添加页面
    */
    @RequestMapping("/turnBookInsert")
    public String turnBookInsert(){
        return "book_insert";
    }

    /**
    * @author  陈佳康
    * @description 异步添加图书操作
    */
    @RequestMapping("/insertBook")
    @ResponseBody
    public Map<String,Object> insertBook(Book book){
        return bookService.insertOneBook(book);
    }
    
    /**
    * @author  陈佳康
    * @description 跳转到图书信息首页
    */
    @RequestMapping("/turnBookIndex")
    public String turnBookIndex(){
        return "book_index";
    }


    /**
    * @author  陈佳康
    * @description 删除的操作
    */
    @RequestMapping("/deleteOneBook")
    @ResponseBody
    public Map<String,Object> deleteOneBook(Long id){
        return bookService.deleteOneBook(id);
    }

    /**
    * @author  陈佳康
    * @description 跳转到修改界面，并将该信息携带过去
    * @params [id]
    * @return  
    * @date  
    */
    @RequestMapping("/turnBookUpdate")
    public String turnBookUpdate(Long id,ModelMap modelMap){
        Map<String, Object> oneBook = bookService.getOneBook(id);
        int code = (Integer) oneBook.get("code");

        if (200 == code){
            modelMap.addAttribute("book",oneBook.get("result"));
            return "book_update";
        }

        return "404";
    }


    @RequestMapping("/updateBook")
    @ResponseBody
    public Map<String,Object> updateBook(Book book){
        return bookService.updateOneBook(book);

    }

}
