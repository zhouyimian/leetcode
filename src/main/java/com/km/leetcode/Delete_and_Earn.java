package com.km.leetcode;

public class Delete_and_Earn {
	public static int deleteAndEarn(int[] nums) {
		int max=0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>max)
				max=nums[i];
		}
		int[] count=new int[max+1];
		for(int i=0;i<nums.length;i++)
			count[nums[i]]++;
		int[][] dp=new int[max+1][2];
		for(int i=1;i<max+1;i++) {
			if(count[i-1]==0) {
				dp[i][0]=dp[i-1][0];
				dp[i][1]=dp[i-1][0]+count[i]*i;
			}
			else {
				dp[i][0]=Math.max(dp[i-1][1], dp[i-1][0]);
				dp[i][1]=Math.max(dp[i-1][1], dp[i-1][0]+count[i]*i);
			}
		}
		return Math.max(dp[max][0], dp[max][1]);
	}

	public static void main(String[] args) {
		int[] nums= {2, 2, 3, 3, 3, 4};
		System.out.println(deleteAndEarn(nums));

	}

}
