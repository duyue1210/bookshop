package com.xuhai.bookshop.mapper;

import com.xuhai.bookshop.bean.BookImage;

import java.util.List;

public interface BookImageMapper {
    int deleteByPrimaryKey(Integer imageId);

    int insert(BookImage record);

    int insertSelective(BookImage record);

    BookImage selectByPrimaryKey(Integer imageId);

    int updateByPrimaryKeySelective(BookImage record);

    int updateByPrimaryKey(BookImage record);

    List<BookImage> getImageListByBookId(Integer movieId);

    int batchInsert(List<BookImage> bookImageList);

    int deleteByBookId(Integer bookId);
}
