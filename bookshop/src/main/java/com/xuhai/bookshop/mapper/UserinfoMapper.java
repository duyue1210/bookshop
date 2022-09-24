package com.xuhai.bookshop.mapper;

import com.xuhai.bookshop.bean.Userinfo;

import java.util.List;

public interface UserinfoMapper {

    int deleteByPrimaryKey(Integer userId);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);

    Userinfo getByUsername(String username);

    List<Userinfo> getAll(Userinfo userinfo);
}
