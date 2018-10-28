package com.f1.results;

import com.f1.results.model.LogLapEntry;
import com.f1.results.model.ResultBoard;
import com.f1.results.service.ResultBuilder;
import com.f1.results.util.FileReader;

import java.util.ArrayList;
import java.util.List;

public class CommandCli {

    public static void main(String[] args) {
        System.out.println("Welcome to F1 Results");

        FileReader fileReader = new FileReader();
        List<String[]> lapEntryList = fileReader.read(args[0]);

        List<LogLapEntry> logLapEntries = new ArrayList<LogLapEntry>();
        for (String[] strings : lapEntryList) {
            logLapEntries.add(new LogLapEntry(strings));
        }

        ResultBuilder resultBuilder = new ResultBuilder();
        for (LogLapEntry logLapEntry : logLapEntries) {
            resultBuilder.add(logLapEntry.getLapEntry());
        }

        ResultBoard resultBoard = resultBuilder.buildResultBoard();
        resultBoard.printResult();
    }

}
