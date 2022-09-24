package com.xuhai.bookshop.service;

import com.xuhai.bookshop.bean.Banner;
import com.xuhai.bookshop.util.ResultJson;

public interface BannerService {
    ResultJson getPage(int page, int limit, Banner banner);
    ResultJson getById(Integer bannerId);
    void saveOrUpdate(Banner banner);
    void deleteById(Integer bannerId);
}
