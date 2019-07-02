package com.km.Array;

public class Remove_Duplicates_from_Sorted_Array {
	public int removeDuplicates(int[] nums) {
		if(nums.length<=1)
			return nums.length;
		int newstart = 0;
		for(int i = 0;i<nums.length;i++){
			nums[newstart++] = nums[i];
			int temp = nums[i];
			while(i<nums.length&&nums[i]==temp) i++;
			if(i==nums.length)
				break;
			else
				i--;
		}
		return newstart;
	}
}
