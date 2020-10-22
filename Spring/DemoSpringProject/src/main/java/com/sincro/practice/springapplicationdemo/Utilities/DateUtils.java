package com.sincro.practice.springapplicationdemo.Utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static Date createDateFromString(String dateString){
        Date date = new Date();
        if(dateString != null){
            try{

                date = DATE_FORMAT.parse(dateString);
            } catch (ParseException e) {
                return date;
            }
        }
        return date;
    }
}
