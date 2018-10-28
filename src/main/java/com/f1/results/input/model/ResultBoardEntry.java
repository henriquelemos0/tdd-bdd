package com.f1.results.input.model;

public class ResultBoardEntry {

    private Integer finalPosition;
    private String pilotCode;
    private String pilotName;
    private Integer completedLaps;
    private String totalElapsedTime;

    public ResultBoardEntry(){
    }

    public ResultBoardEntry(Integer finalPosition, String pilotCode, String pilotName, Integer completedLaps, String totalElapsedTime) {
        this.finalPosition = finalPosition;
        this.pilotCode = pilotCode;
        this.pilotName = pilotName;
        this.completedLaps = completedLaps;
        this.totalElapsedTime = totalElapsedTime;
    }

    public Integer getFinalPosition() {
        return finalPosition;
    }

    public String getPilotCode() {
        return pilotCode;
    }

    public String getPilotName() {
        return pilotName;
    }

    public Integer getCompletedLaps() {
        return completedLaps;
    }

    public String getTotalElapsedTime() {
        return totalElapsedTime;
    }
}
