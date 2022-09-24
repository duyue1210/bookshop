package com.xuhai.bookshop.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuhai.bookshop.bean.Category;
import com.xuhai.bookshop.mapper.CategoryMapper;
import com.xuhai.bookshop.mapper.BookCategoryMapper;
import com.xuhai.bookshop.service.CategoryService;
import com.xuhai.bookshop.util.PageUtil;
import com.xuhai.bookshop.util.RTException;
import com.xuhai.bookshop.util.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private BookCategoryMapper bookCategoryMapper;

    @Override
    public ResultJson getPage(int page,int limit, Category category) {
        PageHelper.startPage(page,limit);
        List<Category> categoryList=categoryMapper.getAll(category);
        PageInfo<Category> pageInfo=new PageInfo<>(categoryList);
       /* Map<String,Object> map=new HashMap<>();
        map.put("list",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        return ResultJson.ok().data(map);*/

        return ResultJson.ok().data(new PageUtil(pageInfo));

    }

    @Override
    public ResultJson getById(Integer categoryId) {
        return ResultJson.ok().data(categoryMapper.selectByPrimaryKey(categoryId));
    }

    @Override
    public ResultJson getSelect() {
        Category category=new Category();
        category.setStatus(1);
        return ResultJson.ok().data(categoryMapper.getAll(category));
    }

    @Override
    public void saveOrUpdate(Category category) {

        if(category.getCategoryId()==null){
            categoryMapper.insertSelective(category);
        }else {
            categoryMapper.updateByPrimaryKeySelective(category);
        }
    }

    @Override
    public void deleteById(Integer categoryId) {

        if(bookCategoryMapper.getBookListByCategoryId(categoryId).size()>0){
            throw new RTException("该分类已被使用，不得删除！");
        }
        categoryMapper.deleteByPrimaryKey(categoryId);
    }
}
