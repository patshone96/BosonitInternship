package com.example.block7crudvalidation;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {

    public static String format(Date date){
        //Formateador de fecha
        SimpleDateFormat DateFor = new SimpleDateFormat("dd-MM-yyyy");

        return DateFor.format(date);

    }
}
