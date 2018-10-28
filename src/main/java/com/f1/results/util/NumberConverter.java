package com.f1.results.util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

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
