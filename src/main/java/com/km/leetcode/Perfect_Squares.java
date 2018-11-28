package com.km.leetcode;

public class Perfect_Squares {
	public static int numSquares(int n) {
		int[] dp=new int[n+1];
		for(int i=0;i<=n;i++) {
			dp[i]=i;
			for(int j=0;j*j<=i;j++) {
				dp[i]=Math.min(dp[i], 1+dp[i-j*j]);
			}
		}
		return dp[n];
	}
	public static void main(String[] args) {
		System.out.println(numSquares(12));
	}
}
