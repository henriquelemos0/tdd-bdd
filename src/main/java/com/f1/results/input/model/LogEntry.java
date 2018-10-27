package com.f1.results.input.model;

import java.time.LocalTime;

public class LogEntry {

    private final String logTime;
    private final String pilot;
    private final Integer lap;
    private final LocalTime lapTime;
    private final Double avgLapTime;

    public LogEntry(String[] columns){
        this.logTime = null;
        this.pilot = null;
        this.lap = null;
        this.lapTime = null;
        this.avgLapTime = null;
    }

    public String getLogTime() {
        return logTime;
    }

    public String getPilot() {
        return pilot;
    }

    public Integer getLap() {
        return lap;
    }

    public LocalTime getLapTime() {
        return lapTime;
    }

    public Double getAvgLapTime() {
        return avgLapTime;
    }
}
