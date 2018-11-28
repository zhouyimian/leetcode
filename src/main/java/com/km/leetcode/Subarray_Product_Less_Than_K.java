package com.km.leetcode;

public class Subarray_Product_Less_Than_K {
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		int[][] dp=new int[nums.length][nums.length];
		int temp = 0;
		int ans=0;
		dp[0][0]=nums[0];
		for(int i=0;i<nums.length-1;i++) {
			int j=0;
			for(j=temp;j<nums.length;j++) {
				if(j==0)
					continue;
				if(j!=temp)
					dp[i][j]=dp[i][j-1]*nums[j];
				if(dp[i][j]>=k) {
					if(i==0)
						ans=j*(j+1)/2;
					else
						ans+=(j-temp)*(temp-i);
					temp=j;
					dp[i+1][j]=dp[i][j]/nums[i];
					break;
				}
			}
		}
		return ans;
	}
}
