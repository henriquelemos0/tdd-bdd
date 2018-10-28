package com.f1.results.input.model;

import com.f1.results.input.util.TimeConverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultBuilder {

    List<ResultBoardEntry> resultBoardEntries = new ArrayList<ResultBoardEntry>();
    Map<Pilot, LatestResult> latestResults = new HashMap<Pilot, LatestResult>();


    public ResultBoard buildResultBoard(){
        Integer finalPosition = 1;
        for (Map.Entry<Pilot, LatestResult> pilotLatestResultEntry : latestResults.entrySet()) {

            resultBoardEntries.add(
                    new ResultBoardEntry(
                            finalPosition++,
                            pilotLatestResultEntry.getKey().getPilotCode(),
                            pilotLatestResultEntry.getKey().getPilotName(),
                            pilotLatestResultEntry.getValue().getLastLap(),
                            TimeConverter.fromMiliToMinutes(pilotLatestResultEntry.getValue().getTotalElapsedTime())
                    )
            );

        }
        return new ResultBoard(resultBoardEntries);
    }

    public void add(LapEntry lapEntry) {
        Pilot pilot = new Pilot(lapEntry.getPilotCode(), lapEntry.getPilotName());

        LatestResult latestResult = latestResults.get(pilot);
        if (latestResult == null){
            latestResult = new LatestResult();
            latestResults.put(pilot,latestResult);
        }

        latestResult.setLastLap(lapEntry.getLap());
        latestResult.incrementElapsedTime(lapEntry.getLapTime());
    }
}
