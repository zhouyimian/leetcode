package com.km.leetcode;

public class Product_of_Array_Except_Self {

	public static void main(String[] args) {
		long ans=1;
		int[] nums= {1,2,3,4};
		int []left=new int[nums.length];
		int []right=new int[nums.length];
		int p;
		left[0]=1;
		right[nums.length-1]=1;
		for(int i=1;i<nums.length;i++) {
			if(i==1) {
				left[i]=nums[i-1];
				right[nums.length-1-i]=nums[nums.length-1];
			}
			else {
				left[i] = left[i - 1] * nums[i-1];
				right[nums.length - 1 - i] = right[nums.length - i] * nums[nums.length - i];
			}
		}
		for(int i=0;i<nums.length;i++)
			nums[i]=left[i]*right[i];
		for(int i=0;i<nums.length;i++)
			System.out.println(nums[i]);
	}
}
