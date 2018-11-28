package com.km.leetcode;

public class Jump_Game {
	public static boolean canJump(int[] nums) {
		if(nums.length<=1)
			return true;
		if(nums[0]==0)
			return false;
		boolean flag=false;
		for(int i=1;i<nums.length;i++) {
			if(nums[i]==0) {
				if (i != nums.length - 1) {
					for (int j = i - 1; j >= 0; j--) {
						if (nums[j] > i - j) {
							flag = true;
							break;
						}
					}
					if (!flag) {
						return false;
					} else {
						flag = false;
					}
				}
				else {
					for (int j = i - 1; j >= 0; j--) {
						if (nums[j] >= i - j) {
							flag = true;
							break;
						}
					}
					if (!flag) {
						return false;
					} else {
						flag = false;
					}
				}
			}
		}
		return true;
	}
}
