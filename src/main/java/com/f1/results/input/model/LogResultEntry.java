package com.f1.results.input.model;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogResultEntry {

    private static final Pattern LAP_TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{2}).(\\d{3})");

    private final String logTime;
    private final ResultEntry resultEntry;

    public LogResultEntry(String[] columns){
        this.logTime = columns[0];
        this.resultEntry = createResultEntry(columns);
    }

    public ResultEntry getResultEntry() {
        return resultEntry;
    }

    public String getLogTime() {
        return logTime;
    }

    private ResultEntry createResultEntry(String[] columns) {
        String pilotCode = columns[1].split(" – ")[0];
        String pilotName = columns[1].split(" – ")[1];
        Integer lap = Integer.valueOf(columns[2]);
        Long lapTime = lapTimeParser(columns[3]);
        Double avgLapSpeed = new Double(parseAvgTime(columns[4]));

        return new ResultEntry(pilotCode, pilotName, lap, lapTime, avgLapSpeed);
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
        return "LogResultEntry{" +
                "logTime='" + logTime + '\'' +
                ", resultEntry=" + resultEntry +
                '}';
    }

}
