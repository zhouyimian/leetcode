package com.km.leetcode;

public class Count_Numbers_with_Unique_Digits {
	public int countNumbersWithUniqueDigits(int n) {
		int ans=10;
		if(n==0)
			return 1;
		if(n==1)
			return 10;
		else for(int i=2;i<=n;i++) {
			ans+=num(i);
		}
		return ans;
	}
	public int num(int n) {
		int count=9;
		for(int i=2;i<=n;i++) {
			count*=(10-i+1);
		}
		return count;
	}
}
