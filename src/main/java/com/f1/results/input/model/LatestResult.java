package com.f1.results.input.model;

public class LatestResult {
    private Integer lastLap;
    private Long totalElapsedTime = 0L;

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
}