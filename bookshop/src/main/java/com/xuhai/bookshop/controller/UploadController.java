package com.xuhai.bookshop.controller;


import com.xuhai.bookshop.util.ImageUtil;
import com.xuhai.bookshop.util.ResultJson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/*上传文件*/
@RestController
public class UploadController {


    @PostMapping("/upload")
    public ResultJson upload(MultipartFile[] file, HttpServletRequest request){

        String uploadPath = request.getRealPath("/")+"static/upload/";
        String fileName= ImageUtil.uploadImg(uploadPath,file);
        return ResultJson.ok().data(fileName);
    }
}
