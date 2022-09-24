package com.xuhai.bookshop.service.Impl;

import com.xuhai.bookshop.bean.Code;
import com.xuhai.bookshop.mapper.CodeMapper;
import com.xuhai.bookshop.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CodeServiceImpl implements CodeService {
    @Autowired
    private CodeMapper codeMapper;

    @Override
    public void addCode(Code code) {

        codeMapper.insertSelective(code);
    }

    @Override
    public boolean checkCode(String uuid, String code) {
        Code codeBean=codeMapper.selectByPrimaryKey(uuid);
        /*判断uuid是否存在*/
        if(codeBean != null && codeBean.getCode().equalsIgnoreCase(code) && codeBean.getExpires().getTime()>System.currentTimeMillis()){
            codeMapper.deleteByPrimaryKey(uuid);
            return true;
        }
        return false;
    }
}
