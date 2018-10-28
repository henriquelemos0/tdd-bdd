package com.f1.results.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pilot pilot = (Pilot) o;
        return Objects.equals(pilotCode, pilot.pilotCode) &&
                Objects.equals(pilotName, pilot.pilotName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pilotCode, pilotName);
    }
}
