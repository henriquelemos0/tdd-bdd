package com.f1.results.input.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultBuilder {

    List<ResultBoardEntry> resultBoardEntries = Collections.EMPTY_LIST;

    public ResultBoard buildResultBoard(){
        List<ResultBoardEntry> resultBoardEntries = new ArrayList<ResultBoardEntry>();
        resultBoardEntries.add(new ResultBoardEntry(1,"001","MASSA",1,"1:00.000"));
        return new ResultBoard(resultBoardEntries);
    }

    public void add(LapEntry lapEntry) {

    }
}
