package com.f1.results.util;

import com.f1.results.model.LapEntry;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileReader {

    /**
     * Extract a list of LapEntry from a log file.
     *
     * @param filePath
     * @return the list of LapEntry
     */
    public static List<LapEntry> extractLogEntriesFromLogFile(String filePath){
        List<String[]> lapEntryList = read(filePath);

        List<LapEntry> logLapEntries = new ArrayList<LapEntry>();
        for (String[] strings : lapEntryList) {
            logLapEntries.add(new LapEntry(strings));
        }

        return logLapEntries;
    }
    /**
     * Read the given file
     * Parses each line spliting by each column
     *
     * @param filePath the file full path
     * @return a list of String[], each line is one log entry containing five strings (columns)
     */
    public static List<String[]> read(String filePath) {
        List<String> logLines = getEntries(filePath);

        List<String[]> logEntries = new ArrayList<String[]>();
        for (String logLine : logLines) {
            logEntries.add(splitColumns(logLine));
        }

        return logEntries;
    }

    /**
     * Read the file and return a each line as string in a list
     *
     * @param filePath the file full path
     * @return a list containing a string for each line
     */
    private static List<String> getEntries(String filePath) {
        List<String> lines = Collections.emptyList();
        try
        {
            lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
        }

        catch (IOException e)
        {
            System.out.println("Could not read " + filePath);
            e.printStackTrace();
        }
        return lines;
    }

    /**
     * Split the line into columns
     * Considering that it may have spaces or tabs, it will split based on a separation of two or more spaces
     *
     * @param logLine
     * @return
     */
    private static String[] splitColumns(String logLine) {
        return logLine.split("\\s{2,}");
    }

}
