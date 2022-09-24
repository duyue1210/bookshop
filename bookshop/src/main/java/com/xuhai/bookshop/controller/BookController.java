package com.xuhai.bookshop.controller;

import com.xuhai.bookshop.bean.Book;
import com.xuhai.bookshop.service.BookService;
import com.xuhai.bookshop.util.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/page")
    public ResultJson page(int page, int limit, Book book){
        return bookService.getPage(page, limit, book);
    }

    @GetMapping("/info/{bookId}")
    public ResultJson info(@PathVariable Integer bookId){
        return bookService.getById(bookId);
    }

    @GetMapping("/bookId}/image")
    public ResultJson bookImage(@PathVariable Integer bookId){
        return bookService.getImageListByBookId(bookId);
    }

    @GetMapping("{bookId}/category")
    public ResultJson bookCategory(@PathVariable Integer bookId){
        return bookService.getCategoryListByBookId(bookId);
    }


    @PostMapping("/update")
    public ResultJson update(@RequestBody Book book){
        bookService.saveOrUpdate(book);
        return ResultJson.ok();
    }

    @DeleteMapping("/delete/{bookId}")
    public ResultJson delete(@PathVariable Integer bookId){
        bookService.deleteById(bookId);
        return ResultJson.ok();
    }

    @PostMapping("/status")
    public ResultJson status(@RequestBody Book book){
        bookService.status(book);
        return ResultJson.ok();
    }
}
