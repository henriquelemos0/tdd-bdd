package com.f1.results.input.model;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResultEntry {

    private static final Pattern LAP_TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{2}).(\\d{3})");

    private final String logTime;
    private final String pilotCode;
    private final String pilotName;
    private final Integer lap;
    private final Long lapTime;
    private final Double avgLapSpeed;


    public ResultEntry(String[] columns){
        this.logTime = columns[0];
        this.pilotCode = columns[1].split(" – ")[0];
        this.pilotName = columns[1].split(" – ")[1];
        this.lap = Integer.valueOf(columns[2]);
        this.lapTime = lapTimeParser(columns[3]);
        this.avgLapSpeed = new Double(parseAvgTime(columns[4]));
    }

    public String getLogTime() {
        return logTime;
    }


    public String getPilotCode() {
        return pilotCode;
    }

    public String getPilotName() {
        return pilotName;
    }

    public Integer getLap() {
        return lap;
    }

    public Long getLapTime() {
        return lapTime;
    }

    public Double getAvgLapSpeed() {
        return avgLapSpeed;
    }

    private static Long lapTimeParser(String lapTimeString) {
        Matcher matcher = LAP_TIME_PATTERN.matcher(lapTimeString);
        if (matcher.matches()) {
            return Long.parseLong(matcher.group(1)) * 60000
                    + Long.parseLong(matcher.group(2)) * 1000
                    + Long.parseLong(matcher.group(3));
        } else {
            throw new IllegalArgumentException("Invalid lap time format " + lapTimeString);
        }
    }

    private static Double parseAvgTime(String avgTime)  {
        NumberFormat format = NumberFormat.getInstance(Locale.getAvailableLocales()[61]);
        try {
            Number number = format.parse(avgTime);
            return number.doubleValue();
        }catch (ParseException e){
            throw new IllegalArgumentException("Invalid average time format " + avgTime);
        }
    }

    @Override
    public String toString() {
        return "ResultEntry{" +
                "logTime='" + logTime + '\'' +
                ", pilotCode='" + pilotCode + '\'' +
                ", pilotName='" + pilotName + '\'' +
                ", lap=" + lap +
                ", lapTime=" + lapTime +
                ", avgLapSpeed=" + avgLapSpeed +
                '}';
    }
}
