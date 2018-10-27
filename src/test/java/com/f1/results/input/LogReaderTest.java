package com.f1.results.input;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class LogReaderTest {

    @Test
    public void readLogInput(){
        String[][] logEntries = new LogReader().read("./input.log");

        String[] logEntry0 = new String[5];
        logEntry0[0] = "23:49:08.277";
        logEntry0[1] = "038 ? F.MASSA";
        logEntry0[2] = "1";
        logEntry0[3] = "1:02.852";
        logEntry0[4] = "44,275";

        Assert.assertArrayEquals(logEntry0,logEntries[0]);
    }
}
