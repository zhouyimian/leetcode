package com.km.Array;

import java.util.Arrays;

public class Next_Permutation {
	public void nextPermutation(int[] nums) {
		for(int i=nums.length-1;i>0;i--) {
			if(nums[i-1]<nums[i]) {
				int min=Integer.MAX_VALUE;
				int min_index=i;
				for(int j=i;j<nums.length;j++) {
					if(nums[j]<min&&nums[j]>nums[i-1]) {
						min=nums[j];
						min_index=j;
					}
				}
				exchange(nums,i-1,min_index);
				Arrays.sort(nums,i,nums.length);
				return;
			}
		}
		Arrays.sort(nums);
		
	}
	void exchange(int[] nums,int i,int j) {
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
	public static void main(String[] args) {
		Next_Permutation test = new Next_Permutation();
		int[] n= {3,2,1};
		test.nextPermutation(n);
		for(int i:n) {
			System.out.println(i);
		}
	}
}
