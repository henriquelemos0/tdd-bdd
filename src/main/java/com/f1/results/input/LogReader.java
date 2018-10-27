package com.f1.results.input;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LogReader {

    public List<String[]> read(String filePath) {
        List<String> logLines = getEntries(filePath);

        List<String[]> logEntries = new ArrayList<String[]>();
        for (String logLine : logLines) {
            logEntries.add(splitColumns(logLine));
        }

        return logEntries;
    }

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

    private String[] splitColumns(String logLine) {
        return logLine.split("\\s{2,}");
    }

}
