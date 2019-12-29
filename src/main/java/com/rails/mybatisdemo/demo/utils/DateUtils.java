package com.rails.mybatisdemo.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static final String yyyyMMdd = "yyyyMMdd";

    public static final String HHmm = "HHmm";

    public static String formatter19 = "yyyy-MM-dd HH:mm:ss";

    public static String yyyyMMddHHmm = "yyyyMMddHHmm";

    public static String yyyyMMddHHmmss = "yyyyMMddHHmmss";

    public static String formatter10 = "yyyy-MM-dd";

    public static String yyyyMMddHHmmssForLoseTime = "yyyy-MM-dd HH:mm:ss.SSS";

    public static Date getCurrentDate() {
        return new Date(System.currentTimeMillis());
    }

    public static String date2String(Date date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }

    public static Date String2Date(String string, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = formatter.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static long getDiffDays(Date startDate, Date endDate) {
        long difftime = endDate.getTime() - startDate.getTime();
        return difftime / (24L * 60L * 60L * 1000L);
    }

    public static long getDiffMinutes(Date startDate, Date endDate) {
        long difftime = endDate.getTime() - startDate.getTime();
        return difftime / (60L * 1000L);
    }

    public static Date dateAdd(Date date, int Calendar_Y_M_D_H_m, int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar_Y_M_D_H_m, num);
        return calendar.getTime();

    }

    public static String minAdd(String yyyyMMddHHmm, int min) {
        Date deptureDatetime = String2Date(yyyyMMddHHmm, DateUtils.yyyyMMddHHmm);
        Date date = DateUtils.dateAdd(deptureDatetime, Calendar.MINUTE, min);
        return date2String(date, DateUtils.yyyyMMddHHmm);

    }

    public static String dayAdd(String yyyyMMdd, int day) {
        Date deptureDatetime = String2Date(yyyyMMdd, DateUtils.yyyyMMdd);
        Date date = DateUtils.dateAdd(deptureDatetime, Calendar.DATE, day);
        return date2String(date, DateUtils.yyyyMMdd);

    }

    public static String yyyyMMdd(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(date);
    }

    public static String HHmmss(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
        return sdf.format(date);
    }

    public static Date covertDateFormat(Date date, String format) {
        String date2String = date2String(date, format);
        return String2Date(date2String, format);

    }


    /**
     * Description:
     *
     * @param timeEnd
     * @return
     * @author wangbin  DateTime 2017年5月27日 下午5:12:25
     */
    public static String covertDateStrFormat(String timeEnd, String fromFormat, String toFormat) {
        Date fromDate = String2Date(timeEnd, fromFormat);
        return date2String(fromDate, toFormat);
    }

}
