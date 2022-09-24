package com.xuhai.bookshop.controller;

import com.xuhai.bookshop.bean.Userinfo;
import com.xuhai.bookshop.service.UserinfoService;
import com.xuhai.bookshop.util.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserinfoController {

    @Autowired
    private UserinfoService userinfoService;

    @GetMapping("/page")
    public ResultJson page(int page, int limit, Userinfo userinfo){
        return userinfoService.getPage(page,limit,userinfo);
    }

    @GetMapping("/info/{userId}")
    public ResultJson info(@PathVariable Integer userId){
        return userinfoService.getById(userId);
    }

    @PostMapping("/update")
    public ResultJson update(@RequestBody Userinfo userinfo){
        userinfoService.update(userinfo);
        return ResultJson.ok();
    }

    @DeleteMapping("/delete/{userId}")
    public ResultJson delete(@PathVariable Integer userId){
        userinfoService.delete(userId);
        return ResultJson.ok();
    }
}
