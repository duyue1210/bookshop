package com.xuhai.bookshop.service;

import com.xuhai.bookshop.bean.Category;
import com.xuhai.bookshop.util.PageUtil;
import com.xuhai.bookshop.util.ResultJson;

import java.sql.ResultSet;

public interface CategoryService {
    ResultJson getPage(int page,int limit, Category category);
    ResultJson getById(Integer categoryId);
    ResultJson getSelect();
    void saveOrUpdate(Category category);
    void deleteById(Integer categoryId);
}
