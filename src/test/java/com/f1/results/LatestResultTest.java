package com.f1.results;

import com.f1.results.model.LatestResult;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LatestResultTest {

    @Test
    public void sortByTime(){
        LatestResult first = new LatestResult();
        first.setLastLap(4);
        first.setTotalElapsedTime(2000L);

        LatestResult last = new LatestResult();
        last.setLastLap(4);
        last.setTotalElapsedTime(3000L);

        List<LatestResult> list = new ArrayList<LatestResult>();
        list.add(last);
        list.add(first);

        Collections.sort(list);

        Assert.assertTrue(list.get(0).equals(first));
        Assert.assertTrue(list.get(1).equals(last));
    }

    @Test
    public void sortByLapAndTime(){
        LatestResult first = new LatestResult();
        first.setLastLap(4);
        first.setTotalElapsedTime(4000L);

        LatestResult last = new LatestResult();
        last.setLastLap(3);
        last.setTotalElapsedTime(3000L);

        List<LatestResult> list = new ArrayList<LatestResult>();
        list.add(last);
        list.add(first);

        Collections.sort(list);

        Assert.assertTrue(list.get(0).equals(first));
        Assert.assertTrue(list.get(1).equals(last));
    }
}
