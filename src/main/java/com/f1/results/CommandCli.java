package com.f1.results;

import com.f1.results.model.LogLapEntry;
import com.f1.results.service.PodiumService;
import com.f1.results.util.FileReader;

import java.util.List;

public class CommandCli {

    public static void main(String[] args) {

        System.out.println("Welcome to F1 Results");

        List<LogLapEntry> logLapEntries = FileReader.extractLogEntriesFromLogFile(args[0]);

        PodiumService podiumService = new PodiumService();
        podiumService.addAllEntriesFromLog(logLapEntries);
        podiumService.showPodium();
    }

}
