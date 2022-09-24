package com.xuhai.bookshop.util;

import com.alibaba.druid.util.StringUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class ImageUtil {
    public static String uploadImg(String uploadPath, MultipartFile[] files) {
        if (files != null && files.length >= 1) {
            BufferedOutputStream bw = null;
            try {
                /*获取原文件的名称(包含格式后缀)*/
                String fileName = files[0].getOriginalFilename();
                // 判断是否有文件
                if (!StringUtils.isEmpty(fileName)) {
                    String uuid = UUID.randomUUID().toString();
                    String uploadFileName = uuid+"."+ getFileType(fileName);
                    // 输出到本地路径
                    File outFile = new File(uploadPath + uploadFileName);
                    FileUtils.copyInputStreamToFile(files[0].getInputStream(), outFile);
                    return uploadFileName;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if(bw!=null){
                        bw.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static String getFileType(String filename){
        /*根据点(.)把字符串拆成数组*/
        String[] fs=filename.split("\\.");
        return fs[fs.length-1];
    }

}
