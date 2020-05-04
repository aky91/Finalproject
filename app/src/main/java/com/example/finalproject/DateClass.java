package com.example.finalproject;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateClass {

    private static DateClass dateClass = new DateClass();

    public DateClass() {

    }

    public static DateClass getInstance() {
        return dateClass;
    }

    // returns current date
    public String getCurrentDateWithWeekDay() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE\ndd.MM.yyyy");
        Date currentDate = new Date();
        return simpleDateFormat.format(currentDate);
    }

    public String getCurrentDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date currentDate = new Date();
        return simpleDateFormat.format(currentDate);
    }



    //returns next or previous date (+1 or -1)
    public static Date changeDate(Date date, int numberOfDays) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, numberOfDays);
        return cal.getTime();
    }

    public int getToDayInt() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String temp = dtf.format(now);
        String time[] = temp.split(" "); //time[0] == yyyy/MM/dd
        final String day[] = time[0].split("/"); //day[2] == d
        return Integer.parseInt(day[2]);
    }
}