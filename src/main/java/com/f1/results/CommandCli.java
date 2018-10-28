package com.f1.results;

import com.f1.results.model.LapEntry;
import com.f1.results.service.PodiumService;
import com.f1.results.util.FileReader;

import java.util.List;

public class CommandCli {

    public static void main(String[] args) {

        System.out.println("Welcome to F1 Results");

        List<LapEntry> logLapEntries = FileReader.extractLogEntriesFromLogFile(args[0]);

        PodiumService podiumService = new PodiumService();
        podiumService.addAll(logLapEntries);
        podiumService.showPodium();
    }

}
