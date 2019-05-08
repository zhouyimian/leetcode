package com.km.leetcode;

public class House_Robber {
	public int rob(int[] nums,int start,int end) {
		if(nums.length==0)
			return 0;
		int[][] dp=new int[nums.length][2];
		dp[start][0]=0;
		dp[start][1]=nums[0];
		for(int i=start+1;i<=end;i++) {
			dp[i][0]=Math.max(dp[i-1][0], dp[i-1][1]);
			dp[i][1]=dp[i-1][0]+nums[i];
		}
		return Math.max(dp[end][0], dp[end][1]);
	}
}
