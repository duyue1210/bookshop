package com.xuhai.bookshop.controller;
import com.xuhai.bookshop.bean.Category;
import com.xuhai.bookshop.service.CategoryService;
import com.xuhai.bookshop.util.PageUtil;
import com.xuhai.bookshop.util.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /*
     * int 是基本数据类型，它的默认值是0，如果请求中不包含page这个属性，那么代码就会直接出现异常
     * Integer 是封装数据类型，它的默认值是null，如果请求中不包括page属性，那么page的值回事null
     * */

    @GetMapping("/page")
    public ResultJson page(int page,int limit, Category category){
        return categoryService.getPage(page,limit,category);
    }

    @GetMapping("/info/{categoryId}")
    public ResultJson info(@PathVariable Integer categoryId){
        return  categoryService.getById(categoryId);
    }

    @GetMapping("/select")
    public ResultJson select(){
        return categoryService.getSelect();
    }

    @PostMapping(value = {"update","/status"})
    public ResultJson update(@RequestBody Category category){
        categoryService.saveOrUpdate(category);
        return ResultJson.ok();
    }

    @DeleteMapping("/delete/{categoryId}")
    public ResultJson delete(@PathVariable Integer categoryId){
        categoryService.deleteById(categoryId);
        return ResultJson.ok();
    }


}
