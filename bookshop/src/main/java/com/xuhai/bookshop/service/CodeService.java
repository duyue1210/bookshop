package com.xuhai.bookshop.service;

import com.xuhai.bookshop.bean.Code;

public interface CodeService {
    void addCode(Code code);
    boolean checkCode(String uuid,String code);
}
