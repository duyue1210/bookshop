package com.xuhai.bookshop.service;

import com.xuhai.bookshop.bean.Author;
import com.xuhai.bookshop.util.ResultJson;

public interface AuthorService {
    ResultJson getPage(int page, int limit, Author author);
    ResultJson getById(Integer authorId);
    ResultJson getSelect();
    void saveOrUpdate(Author author);
    void deleteById(Integer authorId);
}
