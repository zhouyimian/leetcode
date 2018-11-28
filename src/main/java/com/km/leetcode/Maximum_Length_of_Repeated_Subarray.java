package com.km.leetcode;

public class Maximum_Length_of_Repeated_Subarray {
	public int findLength(int[] A, int[] B) {
		int[][] dp=new int[A.length][B.length];
		int max=0;
		for(int i=0;i<A.length;i++) {
			for(int j=0;j<B.length;j++) {
				if(A[i]==B[j]) {
					if(i==0||j==0)
						dp[i][j]=1;
					else
						dp[i][j]=dp[i-1][j-1]+1;
					if(dp[i][j]>max)
						max=dp[i][j];
				}
			}
		}
		return max;
	}
}
