package com.f1.results.model;

public class Pilot {

    private final String pilotCode;
    private final String pilotName;

    public Pilot(String pilotCode, String pilotName) {
        this.pilotCode = pilotCode;
        this.pilotName = pilotName;
    }

    public String getPilotCode() {
        return pilotCode;
    }

    public String getPilotName() {
        return pilotName;
    }
}
