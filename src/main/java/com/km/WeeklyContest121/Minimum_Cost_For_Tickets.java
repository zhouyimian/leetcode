package com.km.WeeklyContest121;

import java.util.Arrays;
import java.util.TreeSet;

public class Minimum_Cost_For_Tickets {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for(int i = 1;i <= n;i++){
            dp[i] = dp[i-1] + costs[0];
            for(int j = i-1;j >= 0;j--){
                if(days[i-1] - days[j] + 1 <= 7){
                    dp[i] = Math.min(dp[i], dp[j] + costs[1]);
                }
                if(days[i-1] - days[j] + 1 <= 30){
                    dp[i] = Math.min(dp[i], dp[j] + costs[2]);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Minimum_Cost_For_Tickets test = new Minimum_Cost_For_Tickets();
        int[] nums={1,5,8,9,10,12,13,16,17,18,19,20,23,24,29};
        int[] costs={3,12,54};
//        int[] nums={1,4,6,7,8,20};
//        int[] costs={2,7,15};
        System.out.println(test.mincostTickets(nums,costs));
    }
}