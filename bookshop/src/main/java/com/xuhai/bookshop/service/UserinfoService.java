package com.xuhai.bookshop.service;

import com.xuhai.bookshop.bean.Userinfo;
import com.xuhai.bookshop.util.ResultJson;

public interface UserinfoService {
    ResultJson login(String username, String password, String uuid, String code);

    ResultJson getPage(int page, int limit, Userinfo userinfo);

    ResultJson getById(Integer userId);

    void update(Userinfo userinfo);
    void delete(Integer userId);
}
