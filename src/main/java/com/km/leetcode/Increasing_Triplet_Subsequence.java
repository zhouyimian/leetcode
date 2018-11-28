package com.km.leetcode;

public class Increasing_Triplet_Subsequence {
	public boolean increasingTriplet(int[] nums) {
		int small=Integer.MAX_VALUE;
		int big=Integer.MAX_VALUE;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]<=small)
				small=nums[i];
			else if(nums[i]<=big)
				big=nums[i];
			else return true;
		}
		return false;

	}
}
