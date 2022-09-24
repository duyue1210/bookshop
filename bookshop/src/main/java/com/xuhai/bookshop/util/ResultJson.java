package com.xuhai.bookshop.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author PangJunjie
 * @Date 2022/3/2/002
 */
public class ResultJson extends HashMap<String, Object> {
    /*初始化状态*/
    private static final Integer SUCCESS = 200;
    private static final Integer ERROR = 500;
    /*构造函数来初始化数据*/
    public ResultJson(){
        super.put("code",SUCCESS);
        super.put("msg","success");
    }

    public static ResultJson ok(){
        return new ResultJson();
    }

    public static ResultJson ok(int code,String msg){
        ResultJson resultJson = new ResultJson();
        resultJson.put("code",code);
        resultJson.put("msg",msg);
        return resultJson;
    }

    public static ResultJson ok(int code){
        return ok(code,"success");
    }

    public static ResultJson ok(String msg){
        return ok(SUCCESS,msg);
    }

    public static ResultJson ok(Map<String, Object> map){
        ResultJson resultJson = new ResultJson();
        resultJson.putAll(map);
        return resultJson;
    }

    public static ResultJson error(int code,String msg){
        ResultJson resultJson = new ResultJson();
        resultJson.put("code",code);
        resultJson.put("msg",msg);
        return resultJson;
    }

    public static ResultJson error(int code){
        return error(code,"error");
    }

    public static ResultJson error(String msg){
        return error(ERROR,msg);
    }

    public static ResultJson error(){
        return error(ERROR,"msg");
    }

    /*实现连式编程*/
    public ResultJson put(String key,Object value){
        super.put(key,value);
        return this;
    }

    public ResultJson data(Object obj){
        super.put("data",obj);
        return this;
    }
}
