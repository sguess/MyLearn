package com.sguess.decision.app;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AApp {
    public static void main(String[] args){
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int hour=calendar.get(Calendar.HOUR_OF_DAY);
        int min=calendar.get(Calendar.MINUTE);
        int sec=calendar.get(Calendar.SECOND);
        int minSec = calendar.get(Calendar.MILLISECOND);

        System.out.println(minSec);
        System.out.println(Calendar.getInstance().get(Calendar.MILLISECOND));

        if(min%2==0||sec%10==0){
            
        }


    }
    public void  fun1(){
        Date date = new Date();
        String dateStr= new SimpleDateFormat("yyyyMMdd HH:mm:ss").format(date);
        int year=Integer.valueOf(new SimpleDateFormat("yyyy").format(date));
        int month=Integer.valueOf(new SimpleDateFormat("MM").format(date));
        int day=Integer.valueOf(new SimpleDateFormat("dd").format(date));
        int hour=Integer.valueOf(new SimpleDateFormat("HH").format(date));
        int min=Integer.valueOf(new SimpleDateFormat("mm").format(date));
        int sec=Integer.valueOf(new SimpleDateFormat("ss").format(date));
        System.out.println(dateStr);

    }
}
