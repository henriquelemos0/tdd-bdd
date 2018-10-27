package com.f1.results.input;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LogReaderTest {

    @Test
    public void readLogInput(){
        List<String[]> logEntries = getLogEntries();

        String[] logEntry0 = new String[5];
        logEntry0[0] = "23:49:08.277";
        logEntry0[1] = "038 ? F.MASSA";
        logEntry0[2] = "1";
        logEntry0[3] = "1:02.852";
        logEntry0[4] = "44,275";

        Assert.assertArrayEquals(logEntry0,logEntries.get(0));
    }

    private List<String[]> getLogEntries() {
        return new LogReader().read(getClass().getClassLoader().getResource("results.log").getPath());
    }
}
