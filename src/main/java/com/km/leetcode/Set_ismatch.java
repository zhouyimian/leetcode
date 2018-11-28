package com.km.leetcode;

public class Set_ismatch {
	public int[] findErrorNums(int[] nums) {
		int[] ans=new int[2];
		int n=0;
		int[] count=new int[nums.length+1];
		for(int i=0;i<nums.length;i++) {
			count[nums[i]]++;
		}
		ans[0]=n;
		for(int i=1;i<=nums.length;i++) {
			if(count[i]==0) {
				ans[1]=i;
				if(ans[0]!=0)
					return ans;
			}
			if(count[i]==2) {
				ans[0]=i;
				if(ans[1]!=0)
					return ans;
			}
		}
		return ans;
	}
}
