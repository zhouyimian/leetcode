package com.km.WeeklyContest108;

public class Minimum_Falling_Path_Sum {
	public int minFallingPathSum(int[][] A) {
		int[][] dp=new int[A.length][A.length];
		for(int i=0;i<A.length;i++)
			dp[0][i]=A[0][i];
		for(int i=1;i<A.length;i++) {
			for(int j=0;j<A.length;j++) {
				dp[i][j]=Math.min(dp[i-1][j], Math.min(j-1>=0?dp[i-1][j-1]:Integer.MAX_VALUE, j+1<A.length?dp[i-1][j+1]:Integer.MAX_VALUE))+A[i][j];
			}
		}
		int ans=Integer.MAX_VALUE;
		for(int i=0;i<A.length;i++) {
			if(ans>dp[A.length-1][i])
				ans=dp[A.length-1][i];
		}
		return ans;
	}

	public static void main(String[] args) {
		Minimum_Falling_Path_Sum test=new Minimum_Falling_Path_Sum();
		int[][] nums= {{17,82},{1,-44}};
		System.out.println(test.minFallingPathSum(nums));

	}

}
