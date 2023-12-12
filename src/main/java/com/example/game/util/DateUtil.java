package com.example.game.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static Date getTimeAfterSecNum(Date date, int num){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.SECOND, num * (-1));//后一秒
        return c.getTime();
    }
}
