package com.Biweekly.BiweeklyContest22;

public class Pizza_With_3n_Slices {
    public int maxSizeSlices(int[] slices) {
        return Math.max(helper(slices, 0, slices.length-1), helper(slices, 1, slices.length));
    }
    public int helper(int[] slices, int start, int end) {
        int n = slices.length;
        int[][] dp = new int[2][n/3+1];
        for (int i = start; i < end; i++) {
            for (int j = Math.min(n/3, (i+2-start)/2); j >= 1; j--) {
                dp[(i+1)%2][j] = Math.max(dp[i%2][j], dp[(i+1)%2][j-1] + slices[i]);
            }
        }
        return Math.max(dp[0][n/3], dp[1][n/3]);
    }
}
