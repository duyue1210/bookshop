package com.xuhai.bookshop.controller;


import com.xuhai.bookshop.bean.Banner;
import com.xuhai.bookshop.service.BannerService;
import com.xuhai.bookshop.util.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/banner")
public class BeannerController {

    @Autowired
    private BannerService bannerService;

    @GetMapping("/page")
    public ResultJson page(int page, int limit, Banner banner){
        return bannerService.getPage(page, limit, banner);
    }

    @GetMapping("/info/{bannerId}")
    public ResultJson info(@PathVariable Integer bannerId){
        return bannerService.getById(bannerId);
    }

    @PostMapping(value = {"/update","/status","/order/num"})
    public ResultJson update(@RequestBody Banner banner){
        bannerService.saveOrUpdate(banner);
        return ResultJson.ok();
    }

    @DeleteMapping("/delete/{bannerId}")
    public ResultJson delete(Integer bannerId){
        bannerService.deleteById(bannerId);
        return ResultJson.ok();
    }
}
