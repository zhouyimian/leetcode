package com.km.leetcode;

public class Minimum_Swaps_To_Make_Sequences_Increasing {
	public static int minSwap(int[] A, int[] B) {
		int[][] dp=new int[A.length][2];
		dp[0][1]=1;
		for(int i=1;i<A.length;i++) {
			dp[i][0]=dp[i][1]=A.length;
			if(A[i]>A[i-1]&&B[i]>B[i-1]) {
				dp[i][0]=dp[i-1][0];
				dp[i][1]=dp[i-1][1]+1;
			}
			if(B[i]>A[i-1]&&A[i]>B[i-1]) {
				dp[i][1]=dp[i][1]=Math.min(dp[i][1], dp[i-1][0]+1);
				dp[i][0]=dp[i][0]=Math.min(dp[i][0], dp[i-1][1]);
			}
		}
		return Math.min(dp[A.length-1][0], dp[A.length-1][1]);
	}

	public static void main(String[] args) {
		int[] A= {1,3,5,4};
		int[] B= {1,2,3,7};
		System.out.println(minSwap(A,B));
		

	}

}
