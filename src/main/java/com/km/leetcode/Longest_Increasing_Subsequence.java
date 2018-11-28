package com.km.leetcode;

public class Longest_Increasing_Subsequence {
	public int lengthOfLIS(int[] nums) {
		int[] ans=new int[nums.length];
		for(int i=0;i<nums.length;i++) {
			ans[i]=1;
		}
		for(int i=1;i<nums.length;i++) {
			for(int j=i-1;j>=0;j--) {
				if(nums[i]>nums[j]) {
					ans[i]=Math.max(ans[i], ans[j]+1);
				}
			}
		}
		int max=0;
		for(int i=0;i<nums.length;i++)
			max=Math.max(max, ans[i]);
		return max;
	}
}
