package com.km.WeeklyContest105;

public class Number_of_Music_Playlists {
    public int numMusicPlaylists(int N, int L, int K) {
        long[][] dp = new long[N+1][L+1];
        dp[0][0]=1;
        long mod = (long)1e9+7;
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= L; j++) {
                dp[i][j] += dp[i][j-1] * Math.max(i - K, 0) + dp[i-1][j-1] * i;
                dp[i][j] %= 1000000007;
            }
        return (int) dp[N][L]%1000000007;
    }
}
