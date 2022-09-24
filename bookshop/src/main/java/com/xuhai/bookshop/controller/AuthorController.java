package com.xuhai.bookshop.controller;

import com.xuhai.bookshop.bean.Author;
import com.xuhai.bookshop.service.AuthorService;
import com.xuhai.bookshop.util.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/page")
    public ResultJson page(int page, int limit, Author author){
        return authorService.getPage(page, limit, author);
    }

    @GetMapping("/info/{authorId}")
    public ResultJson info(@PathVariable Integer authorId){
        return authorService.getById(authorId);
    }

    @GetMapping("/select")
    public ResultJson select(){
        return authorService.getSelect();
    }

    @PostMapping(value = {"/update","/status"})
    public ResultJson update(@RequestBody Author author){
        authorService.saveOrUpdate(author);
        return ResultJson.ok();
    }

    @DeleteMapping("/delete/{authorId}")
    public ResultJson delete(@PathVariable Integer authorId){
        authorService.deleteById(authorId);
        return ResultJson.ok();
    }
}
