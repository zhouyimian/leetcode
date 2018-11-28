package com.km.leetcode;

public class Longest_Continuous_Increasing_Subsequence {
	public int findLengthOfLCIS(int[] nums) {
		int max=0;
		if(nums.length==0)
			return 0;
		int[] LIS=new int[nums.length];
		LIS[0]=1;
		for(int i=1;i<nums.length;i++) {
			if(nums[i]>nums[i-1]) {
				LIS[i]=LIS[i-1]+1;
				if(LIS[i]>max) {
					max=LIS[i];
				}
			}
			else {
				LIS[i]=1;
			}
		}
		return max;
	}
}
