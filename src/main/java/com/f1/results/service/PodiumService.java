package com.f1.results.service;

import com.f1.results.model.LapEntry;
import com.f1.results.model.LatestResult;
import com.f1.results.model.ResultBoardEntry;
import com.f1.results.util.TimeConverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PodiumService {

    private List<ResultBoardEntry> resultBoardEntries ;
    private Map<String, LatestResult> latestResults = new HashMap<String, LatestResult>();

    public void showPodium(){
        calculateResultBoard();
        printResult();
    }

    public List<ResultBoardEntry> calculateResultBoard() {
        resultBoardEntries = new ArrayList<ResultBoardEntry>();
        final Integer[] finalPosition = {1};

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

        return resultBoardEntries;
    }

    public List<ResultBoardEntry> getResultBoardEntries() {
        return resultBoardEntries;
    }

    private void printResult() {
        for (ResultBoardEntry resultBoardEntry : resultBoardEntries) {
            System.out.println(resultBoardEntry);
        }
    }

    public PodiumService addAll(List<LapEntry> lapEntries){
        for (LapEntry lapEntry : lapEntries) {
            add(lapEntry);
        }
        return this;
    }

    public PodiumService add(LapEntry lapEntry) {
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
