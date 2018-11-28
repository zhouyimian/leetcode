package com.km.leetcode;

import java.util.*;

public class Combination_Sum_IV {
	public static int combinationSum4(int[] nums, int target) {
		int[] dp=new int[target+1];
		Arrays.sort(nums);
		for(int i=0;i<nums.length;i++) {
			if(nums[i]<=target)
				dp[nums[i]]=1;
		}
		for(int i=1;i<=target;i++) {
			for(int j=0;j<nums.length;j++) {
				if(i<=nums[j])
					break;
				else
					dp[i]+=dp[i-nums[j]];
			}
		}
		return dp[target];
	}
	public static void main(String[] args) {
		int[] n= {3,1,2,4};
		System.out.println(combinationSum4(n,4));
	}
}
