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
    Map<String, LatestResult> latestResults = new HashMap<String, LatestResult>();

    public ResultBoard buildResultBoard(){

        final Integer[] finalPosition = {1};
        Stream<Map.Entry<String, LatestResult>> sorted;
        latestResults.entrySet().stream()
                .sorted(Map.Entry.<String, LatestResult>comparingByValue())
                .forEachOrdered(x ->
                        resultBoardEntries.add(new ResultBoardEntry(
                                finalPosition[0]++,
                                x.getValue().getPilotCode(),
                                x.getValue().getPilotName(),
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
        LatestResult latestResult = latestResults.get(lapEntry.getPilotCode());
        if (latestResult == null){
            latestResult = new LatestResult(lapEntry.getPilotCode(), lapEntry.getPilotName(), lapEntry.getLap(), lapEntry.getLapTime());
        }else {
            latestResult.setLastLap(lapEntry.getLap());
            latestResult.incrementElapsedTime(lapEntry.getLapTime());
        }

        latestResults.put(lapEntry.getPilotCode(),latestResult);
        return this;
    }
}
