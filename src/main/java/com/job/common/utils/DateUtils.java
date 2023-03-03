package com.job.common.utils;

import javafx.scene.input.DataFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 1、Calendar转换成Date
 * Calendar cal = Calendar.getInstance();
 * Date date = cal.getTime;
 *
 * 2、Date 转换成 Calendar
 * Date date = new Date();
 * Calendar cal = Calendar.getInstance();
 * Cal.setTime(date );
 *
 * 3、SimpleDateFormat
 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 * String date = sdf.format(new Date());
 */

public class DateUtils {
    /**
     * 将时间转换格式
     * @param time
     * @return
     */
    public static String parseDate(Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(time);
    }

    /**
     * 获取当天开始时间
     * @return
     */
    public static Date getStartTime(Date date) {
        Calendar todayStart = Calendar.getInstance();
        todayStart.setTime(date);
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    /**
     * 获取当天结束时间
     * @return
     */
    public static Date getEndTime(Date date) {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.setTime(date);
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    //    public static Date getDateTime(String preCallbackTimeStart){
//        String TimeStart = preCallbackTimeStart.replace("Z", " UTC");
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
//        Date callbackTimeStart = null;
//        try {
//            callbackTimeStart = format.parse(TimeStart);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return callbackTimeStart;
//    }
}
