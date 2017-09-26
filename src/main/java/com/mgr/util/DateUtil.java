package com.mgr.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期处理工具
 * @author
 * @time 2017/03/02
 */
public class DateUtil {

    public static Date AddWeek(int dayType, int count,Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(dayType, count);
        return calendar.getTime();
    }
    /**
     * 获取日期对象
     * @param date
     * @return
     */
    public static Date GetDate(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 获取星期信息
     * @param date
     * @return
     */
    public static String GetWeek(Date date){
        SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
        return dateFm.format(date);
    }

    /**
     * 日期加减
     * @param date
     * @param count
     * @return
     */
    public static Date AddDay(Date date, int count){
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(date);//把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, count);  //设置为前一天
        return calendar.getTime();
    }
    public static String FormatDate(Date date,String format){
        SimpleDateFormat sdf=new SimpleDateFormat(format); //设置时间格式
        return sdf.format(date);    //格式化前一天
    }
}
