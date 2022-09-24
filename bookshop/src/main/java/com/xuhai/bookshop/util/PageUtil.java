package com.xuhai.bookshop.util;

import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;

public class PageUtil {

    private Long total;
    private List<?> list=new ArrayList<>();

    public PageUtil(){

    }

    public PageUtil(PageInfo<?> pageInfo){
        this.list=pageInfo.getList();
        this.total=pageInfo.getTotal();
    }


    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
