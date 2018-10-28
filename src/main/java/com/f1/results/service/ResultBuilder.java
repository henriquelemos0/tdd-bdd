package com.f1.results.service;

import com.f1.results.model.LapEntry;
import com.f1.results.model.LatestResult;
import com.f1.results.model.LogLapEntry;
import com.f1.results.model.Pilot;
import com.f1.results.model.ResultBoard;
import com.f1.results.model.ResultBoardEntry;
import com.f1.results.util.TimeConverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ResultBuilder {

    List<ResultBoardEntry> resultBoardEntries = new ArrayList<ResultBoardEntry>();
    Map<Pilot, LatestResult> latestResults = new HashMap<Pilot, LatestResult>();

    public ResultBoard buildResultBoard(){

        final Integer[] finalPosition = {1};
        Stream<Map.Entry<Pilot, LatestResult>> sorted;
        latestResults.entrySet().stream()
                .sorted(Map.Entry.<Pilot, LatestResult>comparingByValue())
                .forEachOrdered(x ->
                        resultBoardEntries.add(new ResultBoardEntry(
                                finalPosition[0]++,
                                x.getKey().getPilotCode(),
                                x.getKey().getPilotName(),
                                x.getValue().getLastLap(),
                                TimeConverter.fromMiliToMinutes(x.getValue().getTotalElapsedTime())
                        ))
                    );
        return new ResultBoard(resultBoardEntries);
    }

    public ResultBuilder addAllFromLog(List<LogLapEntry> logLapEntries){
        for (LogLapEntry logLapEntry : logLapEntries) {
            add(logLapEntry.getLapEntry());
        }
        return this;
    }

    public ResultBuilder add(LapEntry lapEntry) {
        Pilot pilot = new Pilot(lapEntry.getPilotCode(), lapEntry.getPilotName());

        LatestResult latestResult = latestResults.get(pilot);
        if (latestResult == null){
            latestResult = new LatestResult();
        }

        latestResult.setLastLap(lapEntry.getLap());
        latestResult.incrementElapsedTime(lapEntry.getLapTime());

        latestResults.put(pilot,latestResult);
        return this;
    }
}
