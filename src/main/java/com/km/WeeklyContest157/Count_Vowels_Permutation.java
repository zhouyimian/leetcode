package com.km.WeeklyContest157;

public class Count_Vowels_Permutation {
    public int countVowelPermutation(int n) {
        long[][] dp = new long[n+1][5];
        int MOD = 1000000007;
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[1][3] = 1;
        dp[1][4] = 1;
        for(int i = 2;i<=n;i++){
            dp[i][0] = (dp[i-1][1]+dp[i-1][2]+dp[i-1][4])%MOD;
            dp[i][1] = (dp[i-1][0]+dp[i-1][2])%MOD;
            dp[i][2] = (dp[i-1][1]+dp[i-1][3])%MOD;
            dp[i][3] = (dp[i-1][2])%MOD;
            dp[i][4] = (dp[i-1][2]+dp[i-1][3])%MOD;
        }
        long ans = 0;
        ans = (ans+dp[n][0])%MOD;
        ans = (ans+dp[n][1])%MOD;
        ans = (ans+dp[n][2])%MOD;
        ans = (ans+dp[n][3])%MOD;
        ans = (ans+dp[n][4])%MOD;
        return (int)ans;
    }
}
