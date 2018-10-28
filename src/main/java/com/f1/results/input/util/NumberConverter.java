package com.f1.results.input.util;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberConverter {

    public static Double stringToDoubleBRFormat(String avgTime)  {
        NumberFormat format = NumberFormat.getInstance(Locale.getAvailableLocales()[61]);
        try {
            Number number = format.parse(avgTime);
            return number.doubleValue();
        }catch (ParseException e){
            throw new IllegalArgumentException("Invalid average time format " + avgTime);
        }
    }

}
