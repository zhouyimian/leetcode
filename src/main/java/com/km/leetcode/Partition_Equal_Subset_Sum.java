package com.km.leetcode;

public class Partition_Equal_Subset_Sum {
	public boolean canPartition(int[] nums) {
		int sum=0;
		for(int num:nums)
			sum+=num;
		if(sum%2==1)
			return false;
		int W=sum>>1;
		boolean[] dp=new boolean[W+1];
		dp[0]=true;
		for(int i=0;i<nums.length;i++) {
			for(int j=W;j>=nums[i];j--) {
				dp[j]=dp[j]||dp[j-nums[i]];
			}
		}
		return dp[W];
	}
	public static void main(String[] args) {
		Partition_Equal_Subset_Sum p=new Partition_Equal_Subset_Sum();
		int[] nums= {1,5,11,5};
		System.out.println(p.canPartition(nums));
	}
}