package com.f1.results.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeConverter {

    private static final Pattern MINUTE_TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{2}).(\\d{3})");

    public static String fromMiliToMinutes(Long totalElapsedTime) {
        Date date = new Date(totalElapsedTime);
        DateFormat formatter = new SimpleDateFormat("m:ss.SSS");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        return formatter.format(date);
    }

    public static Long fromMinutesToMilis(String lapTimeString) {
        Matcher matcher = MINUTE_TIME_PATTERN.matcher(lapTimeString);
        if (matcher.matches()) {
            return Long.parseLong(matcher.group(1)) * 60000
                    + Long.parseLong(matcher.group(2)) * 1000
                    + Long.parseLong(matcher.group(3));
        } else {
            throw new IllegalArgumentException("Invalid lap time format " + lapTimeString);
        }
    }

}
