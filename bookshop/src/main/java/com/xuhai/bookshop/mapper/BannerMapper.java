package com.xuhai.bookshop.mapper;

import com.xuhai.bookshop.bean.Banner;

import java.util.List;

public interface BannerMapper {
    int deleteByPrimaryKey(Integer bannerId);

    int insert(Banner record);

    int insertSelective(Banner record);

    Banner selectByPrimaryKey(Integer bannerId);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);

    List<Banner> getAll(Banner banner);
}
