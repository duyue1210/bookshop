package com.xuhai.bookshop.util;


/**
 * @Author PangJunjie
 * @Date 2022/3/2/002
 */
public class RTException extends RuntimeException{
    private Integer code=500;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public RTException(){
        this.msg="服务器内部错误,请稍后再试...";
    }

    public RTException(String msg){
        super(msg);
        this.msg=msg;
    }

    public RTException(String msg,Integer code){
        super(msg);
        this.msg=msg;
        this.code=code;
    }

    public RTException(String msg,Throwable e){
        super(msg,e);
        this.msg=msg;
    }

    public RTException(String msg,Integer code,Throwable e){
        super(msg,e);
        this.msg=msg;
        this.code=code;
    }
}
