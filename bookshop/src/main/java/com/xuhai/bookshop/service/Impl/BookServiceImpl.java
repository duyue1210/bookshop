package com.xuhai.bookshop.service.Impl;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuhai.bookshop.bean.Book;
import com.xuhai.bookshop.bean.BookCategory;
import com.xuhai.bookshop.bean.BookImage;
import com.xuhai.bookshop.mapper.BookCategoryMapper;
import com.xuhai.bookshop.mapper.BookImageMapper;
import com.xuhai.bookshop.mapper.BookMapper;
import com.xuhai.bookshop.service.BookService;
import com.xuhai.bookshop.util.PageUtil;
import com.xuhai.bookshop.util.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookCategoryMapper bookCategoryMapper;

    @Autowired
    private BookImageMapper bookImageMapper;

    @Override
    public ResultJson getPage(int page, int limit, Book book) {
        PageHelper.startPage(page,limit);
        List<Book> bookList = bookMapper.getAll(book);
        return ResultJson.ok().data(new PageUtil(new PageInfo<>(bookList)));
    }

    @Override
    public ResultJson getById(Integer bookId) {
        return ResultJson.ok().data(bookMapper.selectByPrimaryKey(bookId));
    }

    @Override
    public ResultJson getCategoryListByBookId(Integer bookId) {
        return ResultJson.ok().data(bookCategoryMapper.getCategoryListByBookId(bookId));
    }

    @Override
    public ResultJson getImageListByBookId(Integer bookId) {
        return ResultJson.ok().data(bookImageMapper.getImageListByBookId(bookId));
    }

    @Override
    public void saveOrUpdate(Book book) {
        if(book.getBookId() == null){
            /*添加电影信息*/
            bookMapper.insertSelective(book);
        }else{
            /*修改前先删除该电影关联的分类和图片*/
            bookCategoryMapper.deleteByBookId(book.getBookId());
            bookImageMapper.deleteByBookId(book.getBookId());
            bookMapper.updateByPrimaryKeySelective(book);
        }
        /*转换分类数组为集合*/
        if(!StringUtils.isEmpty(book.getCategories())){
            List<BookCategory> bookCategoryList = new ArrayList<>();
            String[] categoryList = book.getCategories().split(",");
            for(String categoryId : categoryList){
                BookCategory bookCategory = new BookCategory();
                bookCategory.setBookId(book.getBookId());
                bookCategory.setCategoryId(Integer.parseInt(categoryId));
                bookCategoryList.add(bookCategory);
            }
            /*批量添加分类信息*/
            bookCategoryMapper.batchInsert(bookCategoryList);
        }
        /*转换图片数组为集合*/
        if(!StringUtils.isEmpty(book.getImages())){
            List<BookImage> bookImageList = new ArrayList<>();
            String[] imageList = book.getImages().split(",");
            for(String image:imageList){
                BookImage bookImage = new BookImage();
                bookImage.setBookId(book.getBookId());
                bookImage.setImageSrc(image);
                bookImageList.add(bookImage);
            }
            bookImageMapper.batchInsert(bookImageList);
        }
    }



    @Override
    public void deleteById(Integer bookId) {
        bookCategoryMapper.deleteByBookId(bookId);
        bookImageMapper.deleteByBookId(bookId);
        bookMapper.deleteByPrimaryKey(bookId);
    }

    @Override
    public void status(Book book) {
        bookMapper.updateByPrimaryKeySelective(book);
    }
}
