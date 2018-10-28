package com.f1.results.model;

import com.f1.results.util.NumberConverter;
import com.f1.results.util.TimeConverter;

public class LogLapEntry {


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
        Long lapTime = TimeConverter.fromMinutesToMilis(columns[3]);
        Double avgLapSpeed = new Double(NumberConverter.stringToDoubleBRFormat(columns[4]));

        return new LapEntry(pilotCode, pilotName, lap, lapTime, avgLapSpeed);
    }

    @Override
    public String toString() {
        return "LogLapEntry{" +
                "logTime='" + logTime + '\'' +
                ", lapEntry=" + lapEntry +
                '}';
    }

}
