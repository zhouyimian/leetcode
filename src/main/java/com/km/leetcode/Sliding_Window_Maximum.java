package com.km.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class Sliding_Window_Maximum {
	public static int[] maxSlidingWindow(int[] nums, int k) {
		if(nums.length==0)
			return new int[0];
		if(k==1)
			return nums;
		int curMax = Integer.MIN_VALUE;
		for (int i = 0; i < k; i++) {
			if (nums[i] > curMax)
				curMax = nums[i];
		}
		if (k == nums.length) {
			int[] ans = new int[1];
			ans[0] = curMax;
			return ans;
		} else {
			int[] ans = new int[nums.length - k + 1];
			ans[0]=curMax;
			int count = 1;
			int start = count;
			int end = start + k - 1;
			for (int i = start; i < nums.length - k + 1; i++) {
				if (nums[end] < curMax) {
					curMax=Integer.MIN_VALUE;
					for (int j = start; j <= end; j++) {
						if (nums[j] > curMax) {
							curMax = nums[j];
						}
					}
				}
				else {
					curMax = nums[end];
				}
				ans[count++] = curMax;
				start=count;
				end = start + k - 1;
			}
			return ans;
		}
	}
	public static void main(String[] args) {
		int[] a= {1,3,-1,-3,5,3,6,7};
		int[] ans=maxSlidingWindow(a,3);
		for(int i:ans)
			System.out.println(i);
	}
}
