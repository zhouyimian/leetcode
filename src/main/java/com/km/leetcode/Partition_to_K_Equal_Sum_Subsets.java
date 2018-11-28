package com.km.leetcode;

import java.util.Arrays;

public class Partition_to_K_Equal_Sum_Subsets {
	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum=0;
		for(int num:nums)
			sum+=num;
		if(sum%k!=0)
			return false;
		sum/=k;
		Arrays.sort(nums);
		boolean[] vis=new boolean[nums.length];
		return help(nums,vis,sum,0,k,0);
	}
	public boolean help(int[] nums, boolean[] vis, int target, int curr_sum, int k, int start) {
		if(k==1)
			return true;
		if(curr_sum==target)
			return help(nums,vis,target,0,k-1,0);
		if(curr_sum>target||start==nums.length)
			return false;
		for(int i=start;i<nums.length;i++) {
			if(vis[i])
				continue;
			vis[i]=true;
			if(help(nums,vis,target,curr_sum+nums[i],k,i))
				return true;
			vis[i]=false;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
