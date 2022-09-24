package com.xuhai.bookshop.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuhai.bookshop.bean.Author;
import com.xuhai.bookshop.bean.Book;
import com.xuhai.bookshop.mapper.AuthorMapper;
import com.xuhai.bookshop.mapper.BookMapper;
import com.xuhai.bookshop.service.AuthorService;
import com.xuhai.bookshop.util.PageUtil;
import com.xuhai.bookshop.util.RTException;
import com.xuhai.bookshop.util.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorMapper authorMapper;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public ResultJson getPage(int page, int limit, Author author) {
        PageHelper.startPage(page,limit);
        List<Author> authorList = authorMapper.getAll(author);
        PageInfo<Author> pageInfo= new PageInfo<>(authorList);
        return ResultJson.ok().data(new PageUtil(pageInfo));
    }

    @Override
    public ResultJson getById(Integer authorId) {
        return ResultJson.ok().data(authorMapper.selectByPrimaryKey(authorId));
    }

    @Override
    public ResultJson getSelect() {
        Author author = new Author();
        author.setStatus(1);
        return ResultJson.ok().data(authorMapper.getAll(author));
    }

    @Override
    public void saveOrUpdate(Author author) {
        if(author.getAuthorId()==null){
            authorMapper.insertSelective(author);
        }else{
            authorMapper.updateByPrimaryKeySelective(author);
        }
    }

    @Override
    public void deleteById(Integer authorId) {
        Book book = new Book();
        book.setAuthorId(authorId);
        List<Book> bookList=bookMapper.getAll(book);
        if(bookList.size()>0){
            throw new RTException("该作者已被使用，不得删除！");
        }
        authorMapper.deleteByPrimaryKey(authorId);
    }
}
