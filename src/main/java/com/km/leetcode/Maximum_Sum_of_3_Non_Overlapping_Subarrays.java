package com.km.leetcode;


public class Maximum_Sum_of_3_Non_Overlapping_Subarrays {
	public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		int[] ans=new int[3];
		int[] dp=new int[nums.length-k+1];
		for(int i=0;i<=nums.length-k;i++) {
			for(int j=0;j<k;j++) {
				dp[i]+=nums[i+j];
			}
		};
		int[] max_Left_index=new int[nums.length];
		int[] max_Right_index=new int[nums.length];
		for(int i=0;i<dp.length;i++) {
			max_Left_index[i]=i;
			max_Right_index[i]=i;
		}
		for(int i=1;i<dp.length;i++) {
			if(dp[i]<=dp[max_Left_index[i-1]]) {
				max_Left_index[i]=max_Left_index[i-1];
			}
		}
		for(int i=dp.length-2;i>=0;i--) {
			if(dp[i]<dp[max_Right_index[i+1]]) {
				max_Right_index[i]=max_Right_index[i+1];
			}
		}
		int max=0;
		for (int i = k; i <=nums.length - 2 * k; i++) {
			if (max_Left_index[i - k] == max_Right_index[i + k]) {
				if (dp[i] + dp[i - k] + dp[i + k] > max) {
					max = dp[i] + dp[i - k] + dp[i + k];
					ans[0] = i - k;
					ans[1] = i;
					ans[2] = i + k;
				}
			} else if (dp[i] + dp[max_Left_index[i - k]] + dp[max_Right_index[i + k]] > max) {
				max = dp[i] + dp[max_Left_index[i - k]] + dp[max_Right_index[i + k]];
				ans[0] = max_Left_index[i - k];
				ans[1] = i;
				ans[2] = max_Right_index[i + k];
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		int[] nums= {4,5,10,6,11,17,4,11,1,3};
		maxSumOfThreeSubarrays(nums,1);
	}
}
