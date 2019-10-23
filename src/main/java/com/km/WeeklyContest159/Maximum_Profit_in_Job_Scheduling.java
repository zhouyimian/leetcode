package com.km.WeeklyContest159;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class Maximum_Profit_in_Job_Scheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for(int i = 0;i<n;i++)
            jobs[i] = new int[]{startTime[i],endTime[i],profit[i]};
        Arrays.sort(jobs, (o1, o2) -> o1[1]-o2[1]);
        TreeMap<Integer,Integer> dp = new TreeMap<>();
        dp.put(0,0);
        for(int[] job:jobs){
            int cur = dp.floorEntry(job[0]).getValue()+job[2];
            if(cur>dp.lastEntry().getKey())
                dp.put(job[1],cur);
        }
        return dp.lastEntry().getValue();
    }
}
