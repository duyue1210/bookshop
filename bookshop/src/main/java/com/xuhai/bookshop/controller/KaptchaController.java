package com.xuhai.bookshop.controller;

import com.google.code.kaptcha.Producer;
import com.xuhai.bookshop.bean.Code;
import com.xuhai.bookshop.service.CodeService;
import com.xuhai.bookshop.util.DateUtil;
import com.xuhai.bookshop.util.RTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class KaptchaController {

    @Autowired
    private CodeService codeService;


    /*验证码生成的类*/
    @Autowired
    private Producer producer;

    @GetMapping("/kaptcha.jpg")
    public void kaptcha(HttpServletResponse response, String uuid) throws IOException {

        if(StringUtils.isEmpty(uuid)){
            throw new RTException("uuid不能为空");
        }
        /*获取验证码*/
        String code = producer.createText();
        /*封装验证码实体类*/
        Code codeBean = new Code();
        codeBean.setUuid(uuid);
        codeBean.setCode(code);
        codeBean.setExpires(DateUtil.addMinutes());
        /*验证码存入数据库*/
        codeService.addCode(codeBean);
        /*生成验证码图片并且输出到浏览器中*/
        response.setDateHeader("Expires",0);
        response.setHeader("Cache-Control","no-store,no-cache,must-revalidate");
        response.addHeader("Cache-Control","post-check=0,pre-check=0");
        response.setHeader("Pragma","no-cache");
        response.setContentType("image/jpeg");
        BufferedImage bi = producer.createImage(code);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi,"jpg",out);
        out.flush();
        out.close();
    }
}
