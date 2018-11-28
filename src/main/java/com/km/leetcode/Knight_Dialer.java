package com.km.leetcode;

public class Knight_Dialer {
	/*public int knightDialer(int N) {
		long[][] dp = new long[10][5010]; // i开始，j步的次数
		long[][] dp2 = new long[10][5010];// i结尾，j步的次数
		for (int i = 0; i < 10; i++) {
			dp[i][1] = 1;
			dp2[i][1] = 1;
		}
		int mod = 1000000007;
		if (N == 1)
			return 10;
		for (int i = 2; i <= N; i++) {
			dp2[0][i] = (dp[4][i - 1] + dp[6][i - 1]);
			dp2[1][i] = (dp[6][i - 1] + dp[8][i - 1]);
			dp2[2][i] = (dp[7][i - 1] + dp[9][i - 1]);
			dp2[3][i] = (dp[4][i - 1] + dp[8][i - 1]);
			dp2[4][i] = (dp[3][i - 1] + dp[9][i - 1] + dp[0][i - 1]);
			dp2[6][i] = (dp[1][i - 1] + dp[7][i - 1] + dp[0][i - 1]);
			dp2[7][i] = (dp[2][i - 1] + dp[6][i - 1]);
			dp2[8][i] = (dp[1][i - 1] + dp[3][i - 1]);
			dp2[9][i] = (dp[2][i - 1] + dp[4][i - 1]);
			for (int j = 0; j < 10; j++)
				dp2[j][i] %= mod;
			dp = dp2;
		}
		long ans=0;
		for (int i = 0; i < 10; i++)
			ans += dp[i][N];
		return (int)ans % mod;
	}*/
	public int knightDialer(int N) {
		long ans = 0;
        int mod=10 ^ 9 + 7;
		long[][] dp = new long[10][5010]; // i开始，j步的次数
		long[][] dp2 = new long[10][5010];// i结尾，j步的次数
		for (int i = 0; i < 10; i++) {
			dp[i][1] = 1;
			dp2[i][1] = 1;
		}
		if (N == 1)
			return 10;
		for (int i = 2; i <= N; i++) {
			dp[0][i] = dp2[0][i - 1] * 2;
			dp[1][i] = dp2[1][i - 1] * 2;
			dp[2][i] = dp2[2][i - 1] * 2;
			dp[3][i] = dp2[3][i - 1] * 2;
			dp[4][i] = dp2[4][i - 1] * 3;
			dp[6][i] = dp2[6][i - 1] * 3;
			dp[7][i] = dp2[7][i - 1] * 2;
			dp[8][i] = dp2[8][i - 1] * 2;
			dp[9][i] = dp2[9][i - 1] * 2;

			dp2[0][i] = (dp[4][i - 1] + dp[6][i - 1]) % mod;
			dp2[1][i] = (dp[6][i - 1] + dp[8][i - 1]) % mod;
			dp2[2][i] = (dp[7][i - 1] + dp[9][i - 1]) % mod;
			dp2[3][i] = (dp[4][i - 1] + dp[8][i - 1]) % mod;
			dp2[4][i] = (dp[3][i - 1] + dp[9][i - 1] + dp[0][i - 1]) % mod;
			dp2[6][i] = (dp[1][i - 1] + dp[7][i - 1] + dp[0][i - 1]) % mod;
			dp2[7][i] = (dp[2][i - 1] + dp[6][i - 1]) % mod;
			dp2[8][i] = (dp[1][i - 1] + dp[3][i - 1]) % mod;
			dp2[9][i] = (dp[2][i - 1] + dp[4][i - 1]) % mod;
		}
		for (int i = 0; i < 10; i++) {
			ans += dp[i][N];
		}
		return (int)(ans% mod);
	}

	public static void main(String[] args) {
		Knight_Dialer test = new Knight_Dialer();
		System.out.println(test.knightDialer(2));
	}

}
