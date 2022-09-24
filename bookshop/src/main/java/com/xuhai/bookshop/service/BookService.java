package com.xuhai.bookshop.service;

import com.xuhai.bookshop.bean.Book;
import com.xuhai.bookshop.util.ResultJson;

public interface BookService {
    ResultJson getPage(int page, int limit, Book book);
    ResultJson getById(Integer bookId);
    ResultJson getCategoryListByBookId(Integer bookId);
    ResultJson getImageListByBookId(Integer bookId);
    void saveOrUpdate(Book book);
    void deleteById(Integer bookId);
    void status(Book book);
}
