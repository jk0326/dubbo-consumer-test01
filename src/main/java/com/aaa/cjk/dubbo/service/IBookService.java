package com.aaa.cjk.dubbo.service;

import com.aaa.cjk.dubbo.model.Book;

import java.util.Map;

public interface IBookService {

    Map<String,Object> getAllBooks();

    Map<String,Object> getOneBook(Long id);

    Map<String,Object> deleteOneBook(Long id);

    Map<String,Object> insertOneBook(Book book);

    Map<String,Object> updateOneBook(Book book);
}
