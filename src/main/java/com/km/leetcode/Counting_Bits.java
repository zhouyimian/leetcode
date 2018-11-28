package com.km.leetcode;

public class Counting_Bits {
	public int[] countBits(int num) {
		int[] ans=new int[num+1];
		ans[0]=1;
		if(num==0)
			return ans;
		for(int i=1;i<=num;i++) {
			if(i%2==0)
				ans[i]=ans[i/2];
			else {
				ans[i]=ans[(i-1)/2]+1;
			}
		}
		ans[0]=0;
		return ans;
	}
}
