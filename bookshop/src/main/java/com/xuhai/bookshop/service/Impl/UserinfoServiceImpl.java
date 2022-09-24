package com.xuhai.bookshop.service.Impl;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuhai.bookshop.bean.Token;
import com.xuhai.bookshop.bean.Userinfo;
import com.xuhai.bookshop.mapper.CodeMapper;
import com.xuhai.bookshop.mapper.TokenMapper;
import com.xuhai.bookshop.mapper.UserinfoMapper;
import com.xuhai.bookshop.service.CodeService;
import com.xuhai.bookshop.service.UserinfoService;
import com.xuhai.bookshop.util.DateUtil;
import com.xuhai.bookshop.util.RTException;
import com.xuhai.bookshop.util.ResultJson;
import com.xuhai.bookshop.util.TokenUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*添加事物注解和服务注解*/
@Service
@Transactional
public class UserinfoServiceImpl implements UserinfoService {

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Autowired
    private TokenMapper tokenMapper;

    @Autowired
    private CodeService  codeService;


    @Override
    public ResultJson login(String username, String password, String uuid, String code) {

        if(StringUtils.isEmpty(uuid)){
            throw new RTException("uuid不能为空或");
        }
        if(!codeService.checkCode(uuid,code)){
            throw new RTException("验证码不正确！！");
        }
        Userinfo userinfo = userinfoMapper.getByUsername(username);
        if(userinfo!=null && userinfo.getPassword().equals(DigestUtils.md5Hex(password))){
            if(userinfo.getStatus()==1){
                String token = TokenUtil.getInstance().makeToken();
                Token tokenBean=new Token();
                tokenBean.setToken(token);
                tokenBean.setId(userinfo.getUserId());
                tokenBean.setExpires(DateUtil.addHours());
                tokenMapper.insertSelective(tokenBean);
                return ResultJson.ok().data(token);
            }else {
                return ResultJson.error("该账户意境被封禁，请联系管理员");
            }
        }


        return ResultJson.error("用户名密码不正确");
    }

    @Override
    public ResultJson getPage(int page, int limit, Userinfo userinfo) {
        PageHelper.startPage(page,limit);
        List<Userinfo> userList = userinfoMapper.getAll(userinfo);
        PageInfo<Userinfo> pageInfo= new PageInfo<>(userList);
        Map<String,Object> map = new HashMap<>();
        map.put("list",userList);
        map.put("total",pageInfo.getTotal());
        return ResultJson.ok().data(map);

    }

    @Override
    public ResultJson getById(Integer userId) {
        return ResultJson.ok().data(userinfoMapper.selectByPrimaryKey(userId));
    }

    @Override
    public void update(Userinfo userinfo) {
        if(userinfo.getUserId()==null){
            userinfo.setPassword(DigestUtils.md5Hex("888888"));
            userinfoMapper.insertSelective(userinfo);
        }else {
            userinfoMapper.updateByPrimaryKeySelective(userinfo);
        }

    }

    @Override
    public void delete(Integer userId) {

        if(userId == 1){
            throw new RTException("超级管理员禁止删除 !!!");
        }
        userinfoMapper.deleteByPrimaryKey(userId);
    }
}
