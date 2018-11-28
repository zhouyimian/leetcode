package com.km.leetcode;

public class Maximum_Subarray {
	public int maxSubArray(int[] nums) {
		if(nums.length==0)
			return 0;
		int[] dp=new int[nums.length];
		dp[0]=nums[0];
		for(int i=1;i<nums.length;i++) {
			dp[i]=Math.max(dp[i-1]+nums[i], nums[i]);
		}
		int max=Integer.MIN_VALUE;
		for(int i=0;i<nums.length;i++)
			max=Math.max(max, dp[i]);
		return max;
	}
}
