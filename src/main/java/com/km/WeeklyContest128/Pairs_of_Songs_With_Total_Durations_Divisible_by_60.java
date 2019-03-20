package com.km.WeeklyContest128;

public class Pairs_of_Songs_With_Total_Durations_Divisible_by_60 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] times = new int[60];
        for (int i : time){
            times[i % 60] ++;
        }
        int count = 0;
        count += times[0] * (times[0]-1) / 2;
        count += times[30] * (times[30]-1) / 2;
        for (int i = 1; i < 30; i++) {
            count += times[i] * times[60-i];
        }
        return count;
    }
}
