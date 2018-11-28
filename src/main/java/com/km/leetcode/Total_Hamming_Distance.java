package com.km.leetcode;

public class Total_Hamming_Distance {
	public int totalHammingDistance(int[] nums) {
		int ans=0;
		for(int i=0;i<32;i++) {
			int count=0;
			for(int j=0;j<nums.length;j++) {
				count+=(nums[j]>>i)&1;
			}
			ans+=count*(nums.length-count);
		}
		return ans;
	}
	public static void main(String[] args) {
		int ans=0;
		int n=15;
		for(int i=0;i<32;i++) {
			ans+=n&1;
			n>>>=1;
			if(i<31)
				ans<<=1;
		}
	}
}
