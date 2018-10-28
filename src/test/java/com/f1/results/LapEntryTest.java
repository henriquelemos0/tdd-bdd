package com.f1.results;

import com.f1.results.model.LapEntry;
import org.junit.Assert;
import org.junit.Test;

public class LapEntryTest {

    @Test
    public void resultEntryParserTest(){

        String[] logEntry0 = new String[5];
        logEntry0[0] = "23:49:08.277";
        logEntry0[1] = "038 – F.MASSA";
        logEntry0[2] = "1";
        logEntry0[3] = "1:02.852";
        logEntry0[4] = "44,275";

        LapEntry resultEntry = new LapEntry(logEntry0);

        Assert.assertEquals("23:49:08.277",resultEntry.getLogTime());
        Assert.assertEquals("038",resultEntry.getPilotCode());
        Assert.assertEquals("F.MASSA",resultEntry.getPilotName());
        Assert.assertEquals(new Integer(1),resultEntry.getLap());
        Assert.assertEquals(new Long(62852),resultEntry.getLapTime());
        Assert.assertEquals(new Double("44.275"),resultEntry.getAvgLapSpeed());

    }
}
