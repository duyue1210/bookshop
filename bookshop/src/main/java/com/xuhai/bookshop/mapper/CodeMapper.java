package com.xuhai.bookshop.mapper;

import com.xuhai.bookshop.bean.Code;

public interface CodeMapper {

    int deleteByPrimaryKey(String uuid);

    int insert(Code record);

    int insertSelective(Code record);

    Code selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Code record);

    int updateByPrimaryKey(Code record);
}
