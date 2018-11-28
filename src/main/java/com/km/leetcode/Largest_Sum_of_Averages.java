package com.km.leetcode;

public class Largest_Sum_of_Averages {
	public static double largestSumOfAverages(int[] A, int K) {
		double[][] dp=new double[A.length][K+1];
		int[] sum=new int[A.length];
		sum[0]=A[0];
		for(int i=1;i<A.length;i++) {
			sum[i]=sum[i-1]+A[i];
		}
		if(K>=A.length)
			return sum[A.length-1];
		for(int i=1;i<A.length;i++) {
			dp[i][1]=sum[i]*1.0/(i+1);
			if(i<=K)
				dp[i-1][i]=sum[i-1];
		}
		for(int i=1;i<A.length;i++) {
			for(int j=2;j<=K;j++) {
				for(int x=1;x<=i;x++) {
					if(j>i+1||i-x+1<j-1)
						break;
					dp[i][j]=Math.max(dp[i][j], dp[i-x][j-1]+(sum[i]-sum[i-x])/(x*1.0));
				}
			}
		}
		return dp[A.length-1][K];
	}
	public static void main(String[] args) {
		int[] num= {4,1,7,5,6,2,3};
		System.out.println(largestSumOfAverages(num,4));
	}
}
