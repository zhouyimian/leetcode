package com.km.leetcode;

public class majorityElement {

	public static void main(String[] args) {
		int[] nums = { 6, 5, 5 };
		int major = nums[0], count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (count == 0) {
				count++;
				major = nums[i];
			} else if (major == nums[i]) {
				count++;
			} else
				count--;
		}
		System.out.println(major);
	}
}
