package com.km.leetcode;

public class Search_Insert_Position {
	public int searchInsert(int[] nums, int target) {
		int ans=0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==target)
				return i;
			else if(nums[i]>target)
				return i;
		}
		return ans==0?nums.length:ans;
	}
}
