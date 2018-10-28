package com.f1.results.input.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

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
                            convertToTime(pilotLatestResultEntry.getValue().getTotalElapsedTime())
                    )
            );

        }
        return new ResultBoard(resultBoardEntries);
    }

    private String convertToTime(Long totalElapsedTime) {
        Date date = new Date(totalElapsedTime);
        DateFormat formatter = new SimpleDateFormat("m:ss.SSS");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        return formatter.format(date);
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
