package com.f1.results.model;

import java.util.Collections;
import java.util.List;

public class ResultBoard {

    private List<ResultBoardEntry> resultBoardEntries = Collections.EMPTY_LIST;

    public ResultBoard(List<ResultBoardEntry> resultBoardEntries) {
        this.resultBoardEntries = resultBoardEntries;
    }

    public List<ResultBoardEntry> getResultBoardEntries() {
        return resultBoardEntries;
    }

    public void printResult() {
        for (ResultBoardEntry resultBoardEntry : resultBoardEntries) {
            System.out.println(resultBoardEntry);
        }
    }
}
