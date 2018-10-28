package com.f1.results.model;

public class LatestResult implements Comparable<LatestResult> {

    private final String pilotCode;
    private final String pilotName;
    private Integer lastLap;
    private Long totalElapsedTime = 0L;

    public LatestResult(String pilotCode, String pilotName, Integer lastLap, Long totalElapsedTime) {
        this.pilotCode = pilotCode;
        this.pilotName = pilotName;
        this.lastLap = lastLap;
        this.totalElapsedTime = totalElapsedTime;
    }

    public String getPilotCode() {
        return pilotCode;
    }

    public String getPilotName() {
        return pilotName;
    }

    public Integer getLastLap() {
        return lastLap;
    }

    public void setLastLap(Integer lastLap) {
        this.lastLap = lastLap;
    }

    public Long getTotalElapsedTime() {
        return totalElapsedTime;
    }

    public void setTotalElapsedTime(Long totalElapsedTime) {
        this.totalElapsedTime = totalElapsedTime;
    }

    public void incrementElapsedTime(Long lapTime) {
        this.totalElapsedTime += lapTime;
    }

    @Override
    public int compareTo(LatestResult o) {
        if (lastLap.compareTo(o.getLastLap()) != 0){
            return o.getLastLap().compareTo(lastLap);
        }else{
            return totalElapsedTime.compareTo(o.getTotalElapsedTime());
        }
    }
}