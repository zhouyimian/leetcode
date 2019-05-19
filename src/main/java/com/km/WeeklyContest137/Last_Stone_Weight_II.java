package com.km.WeeklyContest137;

public class Last_Stone_Weight_II {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for(int num:stones)
            sum+=num;
        int[][] dp = new int[stones.length+1][sum+1];
        for(int i = 0;i<stones.length;i++){
            for(int j = 1;j<=sum/2;j++){
                dp[i+1][j] = dp[i][j];
                if(stones[i]<=j)
                    dp[i+1][j] = Math.max(dp[i+1][j],dp[i][j-stones[i]]+stones[i]);
            }
        }
        return sum-2*dp[stones.length][sum/2];
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        Last_Stone_Weight_II test = new Last_Stone_Weight_II();
        System.out.println(test.lastStoneWeightII(nums));
    }
}
