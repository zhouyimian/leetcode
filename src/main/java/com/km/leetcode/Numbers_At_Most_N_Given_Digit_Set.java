package com.km.leetcode;

public class Numbers_At_Most_N_Given_Digit_Set {
	public int atMostNGivenDigitSet(String[] D, int N) {
		int ans=0;
		String s=N+"";
		int dp[][][]=new int[s.length()][s.length()][D.length];
		for(int i=1;i<s.length();i++) {
			for(int j=0;j<=i;j++) {
				for(int k=0;k<D.length;k++) {
					if(i!=s.length()-1) {
						dp[i][j][Integer.parseInt(D[k])]=1;
					}
				}
			}
		}
		return ans;
	}
}
