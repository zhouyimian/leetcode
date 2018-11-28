package com.km.leetcode;

import java.util.*;

public class Pattern {
	public boolean find132pattern(int[] nums) {
		int max=Integer.MAX_VALUE;
		for(int i=0;i<nums.length-1;i++) {
			if(nums[i]>nums[i+1])
				continue;
			else {
				max=Integer.MAX_VALUE;
				for (int j = i + 1; j < nums.length; j++) {
					if (max==Integer.MAX_VALUE) {
						max=nums[j];
						continue;
					}
					else if(nums[j]>max) {
						max=nums[j];
						continue; 
					}
					else if(nums[j]<max&&nums[j]>nums[i])
						return true;
				}
			}
		}
		return false;
	}
}
