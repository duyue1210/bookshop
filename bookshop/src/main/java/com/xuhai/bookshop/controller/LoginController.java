package com.xuhai.bookshop.controller;

import com.xuhai.bookshop.service.UserinfoService;
import com.xuhai.bookshop.util.ResultJson;
import com.xuhai.bookshop.service.UserinfoService;
import com.xuhai.bookshop.util.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class LoginController {

    @Autowired
    private UserinfoService userinfoService;

    @PostMapping("/login")
    public ResultJson login(String username, String password, String uuid, String code){
        return userinfoService.login(username,password,uuid,code);
    }


}
