package com.f1.results.input;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LogReader {

    /**
     * Read the given file
     * Parses each line spliting by each column
     *
     * @param filePath the file full path
     * @return a list of String[], each line is one log entry containing five strings (columns)
     */
    public List<String[]> read(String filePath) {
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
    private List<String> getEntries(String filePath) {
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
    private String[] splitColumns(String logLine) {
        return logLine.split("\\s{2,}");
    }

}
