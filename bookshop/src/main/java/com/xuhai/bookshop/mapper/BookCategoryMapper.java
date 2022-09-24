package com.xuhai.bookshop.mapper;

import com.xuhai.bookshop.bean.Category;
import com.xuhai.bookshop.bean.Book;
import com.xuhai.bookshop.bean.BookCategory;

import java.util.List;

public interface BookCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookCategory record);

    int insertSelective(BookCategory record);

    BookCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookCategory record);

    int updateByPrimaryKey(BookCategory record);

    List<Book> getBookListByCategoryId(Integer categoryId);

    List<Category> getCategoryListByBookId(Integer bookId);

    int batchInsert(List<BookCategory> bookCategoryList);

    int deleteByBookId(Integer bookId);
}
