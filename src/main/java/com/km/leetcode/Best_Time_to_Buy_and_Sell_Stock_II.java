package com.km.leetcode;

public class Best_Time_to_Buy_and_Sell_Stock_II {

	public static void main(String[] args) {
		int[] nums= {2,1};
		int[] dp=new int[nums.length];
		dp[0]=1;
		for(int i=1;i<nums.length;i++) {
			dp[i]=(nums[i]>nums[i-1]?dp[i-1]+1:1);
		}
//		for(int i=0;i<nums.length;i++) {
//			System.out.println(dp[i]);
//		}
		int sum=0;
		int indexfirst=0,indexlast = 0;
		for(int i=1;i<=nums.length-1;i++) {
			if(dp[i]==1) {
				if(dp[indexlast]>1) {
					sum+=(nums[indexlast]-nums[indexfirst]);
					indexlast=i;
				}
				if(dp[indexfirst]==1)
					indexfirst=i;
			}
			if(dp[i]>1)
				indexlast=i;
		}
		if(nums[indexlast]>nums[indexfirst]&&indexlast>indexfirst)
			sum+=(nums[indexlast]-nums[indexfirst]);
		System.out.println(sum);
	}

}
