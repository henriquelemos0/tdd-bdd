package com.f1.results.input;

import com.f1.results.input.model.LogEntry;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;

public class LogEntryTest {

    @Test
    public void logEntryParserTest(){

        String[] logEntry0 = new String[5];
        logEntry0[0] = "23:49:08.277";
        logEntry0[1] = "038 – F.MASSA";
        logEntry0[2] = "1";
        logEntry0[3] = "1:02.852";
        logEntry0[4] = "44,275";

        LogEntry logEntry = new LogEntry(logEntry0);

        Assert.assertEquals("23:49:08.277",logEntry.getLogTime());
        Assert.assertEquals("038 – F.MASSA",logEntry.getPilot());
        Assert.assertEquals(new Integer(1),logEntry.getLap());
        Assert.assertEquals(new Long(62852),logEntry.getLapTime());
        Assert.assertEquals(new Double("44.275"),logEntry.getAvgLapTime());

    }
}
