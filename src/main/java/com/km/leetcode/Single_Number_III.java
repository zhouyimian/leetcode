package com.km.leetcode;

public class Single_Number_III {
	public static int[] singleNumber(int[] nums) {
		if(nums.length<=1)
			return new int[2];
		int[] ans= {0,0};
		int count=0;
		for(int i=0;i<nums.length;i++) {
			count^=nums[i];
		}
		count&=-count;
		for(int i=0;i<nums.length;i++) {
			if((nums[i]&count)==0) {
				ans[0]^=nums[i];
			}
			else {
				ans[1]^=nums[i];
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		int n=100;
		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(-n));
		System.out.println(n&(-n));
	}
}
