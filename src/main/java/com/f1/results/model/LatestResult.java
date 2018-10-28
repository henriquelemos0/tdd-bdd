package com.f1.results.model;

public class LatestResult implements Comparable<LatestResult> {
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

    @Override
    public int compareTo(LatestResult o) {
        if (totalElapsedTime.compareTo(o.getTotalElapsedTime()) != 0){
            return o.getTotalElapsedTime().compareTo(totalElapsedTime);
        }else{
            return totalElapsedTime.compareTo(o.getTotalElapsedTime());
        }
    }
}