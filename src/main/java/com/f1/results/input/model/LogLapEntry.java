package com.f1.results.input.model;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogLapEntry {

    private static final Pattern LAP_TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{2}).(\\d{3})");

    private final String logTime;
    private final LapEntry lapEntry;

    public LogLapEntry(String[] columns){
        this.logTime = columns[0];
        this.lapEntry = createResultEntry(columns);
    }

    public LapEntry getLapEntry() {
        return lapEntry;
    }

    public String getLogTime() {
        return logTime;
    }

    private LapEntry createResultEntry(String[] columns) {
        String pilotCode = columns[1].split(" – ")[0];
        String pilotName = columns[1].split(" – ")[1];
        Integer lap = Integer.valueOf(columns[2]);
        Long lapTime = lapTimeParser(columns[3]);
        Double avgLapSpeed = new Double(parseAvgTime(columns[4]));

        return new LapEntry(pilotCode, pilotName, lap, lapTime, avgLapSpeed);
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
        return "LogLapEntry{" +
                "logTime='" + logTime + '\'' +
                ", lapEntry=" + lapEntry +
                '}';
    }

}
