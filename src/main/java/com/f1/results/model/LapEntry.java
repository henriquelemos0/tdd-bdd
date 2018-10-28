package com.f1.results.model;

import java.util.regex.Pattern;

public class LapEntry {

    private static final Pattern LAP_TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{2}).(\\d{3})");

    private String pilotCode;
    private String pilotName;
    private Integer lap;
    private Long lapTime;
    private Double avgLapSpeed;

    public LapEntry(){
    }

    public LapEntry(String pilotCode, String pilotName, Integer lap, Long lapTime, Double avgLapSpeed) {
        this.pilotCode = pilotCode;
        this.pilotName = pilotName;
        this.lap = lap;
        this.lapTime = lapTime;
        this.avgLapSpeed = avgLapSpeed;
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

    @Override
    public String toString() {
        return "LapEntry{" +
                "pilotCode='" + pilotCode + '\'' +
                ", pilotName='" + pilotName + '\'' +
                ", lap=" + lap +
                ", lapTime=" + lapTime +
                ", avgLapSpeed=" + avgLapSpeed +
                '}';
    }
}