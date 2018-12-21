package com.km.leetcode;

public class Binary_Subarrays_With_Sum {
	public int numSubarraysWithSum(int[] A, int S) {
		int ans=0,count[]=new int[A.length+1];
		count[0]=1;
		int psum=0;
		for(int num:A){
			psum+=num;
			if(psum>=S)
				ans+=count[psum-S];
			count[psum]++;
		}
		return ans;
	}

	public static void main(String[] args) {
		Binary_Subarrays_With_Sum test = new Binary_Subarrays_With_Sum();
		int[] nums = { 1, 0, 1, 0, 1 };
		System.out.println(test.numSubarraysWithSum(nums, 2));
	}

}
