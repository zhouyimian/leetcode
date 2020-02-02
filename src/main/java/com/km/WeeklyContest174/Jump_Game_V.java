package com.km.WeeklyContest174;

public class Jump_Game_V {
    public static int func(int[] arr, int n, int i, int d, int[] dp) {
        if(i < 0 || i > n) return 0;
        if(dp[i] != -1) return dp[i];
        int maxAns = 0;
        for(int j = 1; j <= d; j++) {
            if(i + j == n) break;
            if(arr[i] > arr[i + j]) maxAns = Math.max(maxAns, func(arr, n, i + j, d, dp));
            else break;
        }
        for(int j = 1; j <= d; j++) {
            if(i - j == -1) break;
            if(arr[i] > arr[i - j]) maxAns = Math.max(maxAns, func(arr, n, i - j, d, dp));
            else break;
        }
        return dp[i] = maxAns + 1;
    }
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) dp[i] = -1;
        int max = 0;
        for(int i = 0; i < n; i++) max = Math.max(max, func(arr, n, i, d, dp));
        return max;
    }
}
