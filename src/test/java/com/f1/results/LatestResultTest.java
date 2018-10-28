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
        LatestResult first = new LatestResult("1","A",4,2000L);
        LatestResult last = new LatestResult("2","b",4,3000L);

        List<LatestResult> list = new ArrayList<LatestResult>();
        list.add(last);
        list.add(first);

        Collections.sort(list);

        Assert.assertTrue(list.get(0).equals(first));
        Assert.assertTrue(list.get(1).equals(last));
    }

    @Test
    public void sortByLapAndTime(){
        LatestResult first = new LatestResult("1","A",4,4000L);;

        LatestResult last = new LatestResult("1","A",3,3000L);

        List<LatestResult> list = new ArrayList<LatestResult>();
        list.add(last);
        list.add(first);

        Collections.sort(list);

        Assert.assertTrue(list.get(0).equals(first));
        Assert.assertTrue(list.get(1).equals(last));
    }
}
