package com.xuhai.bookshop.util;

import java.util.Date;

public class DateUtil {

    /*初始化分钟数*/
    private static final Integer INIT_MINUTES=5;
    /*初始化小时数*/
    private static final Integer INIT_HOURS=12;


    /*
    *设置minutes分钟后的Date对象
    *minutes 分钟数
    *  */

    public static Date addMinutes(Integer minutes){
        Date date = new Date();
        date.setMinutes(date.getMinutes()+minutes);
        return date;
    }

    public static Date addMinutes(){
        return addMinutes(INIT_MINUTES);
    }

    public static Date addHours(int hours){
        Date date = new Date();
        date.setHours(date.getHours()+hours);
        return date;
    }

    public static Date addHours(){
        return addHours(INIT_HOURS);
    }
}
