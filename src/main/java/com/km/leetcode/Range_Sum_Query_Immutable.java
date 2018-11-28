package com.km.leetcode;

public class Range_Sum_Query_Immutable {
	int[] sum;
    int[] num;
	public Range_Sum_Query_Immutable(int[] nums) {
        if(nums.length==0||nums==null)
			return;
		sum=new int[nums.length];
        this.num=nums;
		sum[0]=nums[0];
		for(int i=1;i<nums.length;i++) {
			sum[i]=sum[i-1]+nums[i];
		}
	}

	public int sumRange(int i, int j) {
		return sum[j]-sum[i]+num[i];
	}
}
