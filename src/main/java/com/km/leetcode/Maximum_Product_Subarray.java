package com.km.leetcode;

public class Maximum_Product_Subarray {
	public static int maxProduct(int[] nums) {
		if(nums.length==1)
			return nums[0];
		if(nums.length==0)
			return 0;
		int[] dp1=new int[nums.length];
		int[] dp2=new int[nums.length];
		if(nums[0]>0) {
			dp1[0]=nums[0];
			dp2[0]=0;
		}
		else {
			dp1[0]=0;
			dp2[0]=nums[0];
		}
		for(int i=1;i<nums.length;i++) {
			if(nums[i]<0)
				dp1[i]=Math.max(dp2[i-1]*nums[i],nums[i]);
			else if(nums[i]>0)
				dp1[i]=Math.max(dp1[i-1]*nums[i], nums[i]);
			if(nums[i]>0)
				dp2[i]=Math.min(dp2[i-1]*nums[i], nums[i]);
			else if(nums[i]<0)
				dp2[i]=Math.min(dp1[i-1]*nums[i], nums[i]);
		}
		int max=Integer.MIN_VALUE;
		for(int i=0;i<nums.length;i++) {
			if(dp1[i]>max)
				max=dp1[i];
		}
		return max;
	}
	public static void main(String[] args) {
		int[] nums= {-6,-3,5,-4,-5};
		System.out.println(maxProduct(nums));
	}
}
