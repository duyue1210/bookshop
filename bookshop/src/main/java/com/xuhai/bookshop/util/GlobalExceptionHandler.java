package com.xuhai.bookshop.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author PangJunjie
 * @Date 2022/3/2/002
 */
/*
 * 这两个注解可以简写
 * @ControllerAdvice
 * @ResponseBody
 *
 *  @ControllerAdvice表示通知型控制器，会自动检测指定的异常进行返回
 * */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(RTException.class)
    public ResultJson handleRTException(RTException e){
        logger.error(e.getMessage(),e);
        return ResultJson.error(e.getCode(),e.getMsg());
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResultJson handlerDuplicateKeyException(DuplicateKeyException e){
        logger.error(e.getMessage(),e);
        return ResultJson.error("数据库已存在该记录");
    }

    @ExceptionHandler(Exception.class)
    public ResultJson handelException(Exception e){
        return ResultJson.error("服务器内部错误").put("exception",e.getMessage());
    }

}
