package com.km.leetcode;

public class Single_Element_in_a_Sorted_Array {
	public int singleNonDuplicate(int[] nums) {
		int ans=0;
		for(int i=0;i<nums.length;i++)
			ans=ans^nums[i];
		return ans;
	}
}
