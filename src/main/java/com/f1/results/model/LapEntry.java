package com.f1.results.model;

import com.f1.results.util.NumberConverter;
import com.f1.results.util.TimeConverter;

public class LapEntry {

    private String logTime;
    private String pilotCode;
    private String pilotName;
    private Integer lap;
    private Long lapTime;
    private Double avgLapSpeed;

    public LapEntry() {
    }

    public LapEntry(String[] columns){
        this.logTime = columns[0];
        this.pilotCode = columns[1].split(" – ")[0];
        this.pilotName = columns[1].split(" – ")[1];
        this.lap = Integer.valueOf(columns[2]);
        this.lapTime = TimeConverter.fromMinutesToMilis(columns[3]);
        this.avgLapSpeed = new Double(NumberConverter.stringToDoubleBRFormat(columns[4]));
    }

    public LapEntry(String logTime, String pilotCode, String pilotName, Integer lap, Long lapTime, Double avgLapSpeed) {
        this.logTime = logTime;
        this.pilotCode = pilotCode;
        this.pilotName = pilotName;
        this.lap = lap;
        this.lapTime = lapTime;
        this.avgLapSpeed = avgLapSpeed;
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
}
