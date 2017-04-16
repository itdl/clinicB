package com.mgr.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期处理工具
 * @author
 * @time 2017/03/02
 */
public class DateUtil {
    public static String AddDate(int dayType, int count){
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(System.currentTimeMillis());
        calendar.setTime(date);
        calendar.add(dayType, count);
        date = calendar.getTime();
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }
}
