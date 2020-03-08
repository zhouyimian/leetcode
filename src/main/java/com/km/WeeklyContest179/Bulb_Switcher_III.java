package com.km.WeeklyContest179;

public class Bulb_Switcher_III {
    public int numTimesAllBlue(int[] light) {
        int ans = 0;
        int max = -1;
        for(int i = 0;i<light.length;i++){
            max = Math.max(max,light[i]);
            if(max==i+1)
                ans++;
        }
        return ans;
    }
}
