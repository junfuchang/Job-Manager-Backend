package com.job.common.utils;

import javafx.scene.input.DataFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtils {
    public static Date getDateTime(String preCallbackTimeStart){
        String TimeStart = preCallbackTimeStart.replace("Z", " UTC");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        Date callbackTimeStart = null;
        try {
            callbackTimeStart = format.parse(TimeStart);
        }catch (Exception e){
            e.printStackTrace();
        }
        return callbackTimeStart;
    }
}
