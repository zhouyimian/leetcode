package com.km.WeeklyContest173;

import java.util.Arrays;

public class Minimum_Difficulty_of_a_Job_Schedule {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int ans = 0;
        if (jobDifficulty.length < d)
            return -1;
        else if (jobDifficulty.length == d) {
            int sum = 0;
            for (int num : jobDifficulty)
                sum += num;
            return sum;
        } else {
            int[][] rangeMax = buildRangeMax(jobDifficulty);
            int[][] dp = new int[jobDifficulty.length + 1][d + 1];
            for (int[] nums : dp)
                Arrays.fill(nums, Integer.MAX_VALUE);
            int sum = 0;
            for (int i = 0; i < jobDifficulty.length && i < d; i++) {
                sum += jobDifficulty[i];
                dp[i + 1][i + 1] = sum;
            }
            for (int i = 1; i <= jobDifficulty.length; i++) {
                for (int j = 1; j < i && j <= d; j++) {
                    if(j==1){
                        dp[i][j] = rangeMax[1][i];
                        continue;
                    }
                    for (int k = j - 1; k < i&&k>=1; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[k][j - 1] + rangeMax[k + 1][i]);
                    }
                }
            }
            return dp[jobDifficulty.length][d];
        }
    }

    private int[] buildPreSum(int[] jobDifficulty) {
        int[] presum = new int[jobDifficulty.length + 1];
        for (int i = 1; i <= jobDifficulty.length; i++)
            presum[i] = presum[i - 1] + jobDifficulty[i - 1];
        return presum;
    }

    private int[][] buildRangeMax(int[] jobDifficulty) {
        int length = jobDifficulty.length;
        int[][] res = new int[length + 1][length + 1];
        for (int i = 1; i <= length; i++) {
            for (int j = i; j <= length; j++) {
                if (i == j) {
                    res[i][j] = jobDifficulty[i - 1];
                } else {
                    int max = jobDifficulty[i-1];
                    for (int k = i + 1; k <= j; k++)
                        max = Math.max(max, jobDifficulty[k - 1]);
                    res[i][j] = max;
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        Minimum_Difficulty_of_a_Job_Schedule test = new Minimum_Difficulty_of_a_Job_Schedule();
        int[] diff = {11,111,22,222,33,333,44,444};
        System.out.println(test.minDifficulty(diff, 6));
    }
}
