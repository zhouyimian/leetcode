package com.Biweekly.BiweeklyContest20;

public class Count_All_Valid_Pickup_and_Delivery_Options {
    public int countOrders(int n) {
        int mod = 1000000007;
        long[] dp = new long[n+1];
        dp[1] = 2;
        for(int i = 2;i<=n;i++){
            dp[i] = (dp[i-1]*cal(i))%mod;
        }
        return (int)dp[n];
    }

    private long cal(int num) {
        long ans = 0;
        int count = (num-1)*2;
        for(int i = 0;i<=count;i++){
            ans+=(count-i+1);
        }
        return ans;
    }
}
