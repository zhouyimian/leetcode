package com.km.leetcode;

public class Count_Primes {
	public int countPrimes(int n) {
		int ans=0;
		int[] prim=new int[n];
		for(int i=2;i<n;i++) {
			for(int j=2;j*i<n;j++) {
				prim[j*i]=1;
			}
		}
		for(int i=2;i<n;i++) {
			if(prim[i]==0)
				ans++;
		}
		return ans;
	}
}
