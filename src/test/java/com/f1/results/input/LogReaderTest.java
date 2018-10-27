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

        String[] logEntry1 = new String[5];
        logEntry1[0] = "23:49:11.075";
        logEntry1[1] = "002 ? K.RAIKKONEN";
        logEntry1[2] = "1";
        logEntry1[3] = "1:04.108";
        logEntry1[4] = "43,408";

        String[] logEntry2 = new String[5];
        logEntry2[0] = "23:49:30.976";
        logEntry2[1] = "015 ? F.ALONSO";
        logEntry2[2] = "1";
        logEntry2[3] = "1:18.456";
        logEntry2[4] = "35,47";

        String[] logEntry3 = new String[5];
        logEntry3[0] = "23:51:18.576";
        logEntry3[1] = "033 ? R.BARRICHELLO";
        logEntry3[2] = "3";
        logEntry3[3] = "1:03.716";
        logEntry3[4] = "43,675";

        Assert.assertArrayEquals(logEntry0,logEntries.get(0));
        Assert.assertArrayEquals(logEntry1,logEntries.get(1));
        Assert.assertArrayEquals(logEntry2,logEntries.get(2));
        Assert.assertArrayEquals(logEntry3,logEntries.get(3));
    }

    private List<String[]> getLogEntries() {
        return new LogReader().read(getClass().getClassLoader().getResource("results.log").getPath());
    }

}
