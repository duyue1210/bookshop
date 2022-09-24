package com.xuhai.bookshop.service.Impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuhai.bookshop.bean.Banner;
import com.xuhai.bookshop.mapper.BannerMapper;
import com.xuhai.bookshop.service.BannerService;
import com.xuhai.bookshop.util.PageUtil;
import com.xuhai.bookshop.util.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public ResultJson getPage(int page, int limit, Banner banner) {
        PageHelper.startPage(page,limit);
        List<Banner> bannerList = bannerMapper.getAll(banner);
        return ResultJson.ok().data(new PageUtil(new PageInfo<>(bannerList)));
    }

    @Override
    public ResultJson getById(Integer bannerId) {
        return ResultJson.ok().data(bannerMapper.selectByPrimaryKey(bannerId));
    }

    @Override
    public void saveOrUpdate(Banner banner) {
        if(banner.getBannerId() == null){
            bannerMapper.insertSelective(banner);
        }else{
            bannerMapper.updateByPrimaryKeySelective(banner);
        }
    }

    @Override
    public void deleteById(Integer bannerId) {
        bannerMapper.deleteByPrimaryKey(bannerId);
    }
}
