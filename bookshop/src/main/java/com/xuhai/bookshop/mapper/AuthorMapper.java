package com.xuhai.bookshop.mapper;

import com.xuhai.bookshop.bean.Author;

import java.util.List;

public interface AuthorMapper {
    int deleteByPrimaryKey(Integer authorId);

    int insert(Author record);

    int insertSelective(Author record);

    Author selectByPrimaryKey(Integer authorId);

    int updateByPrimaryKeySelective(Author record);

    int updateByPrimaryKey(Author record);

    List<Author> getAll(Author author);
}
