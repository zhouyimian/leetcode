package com.km.leetcode;

public class Guess_Number_Higher_or_Lower_II {
	static int[][] dp;
	public static int getMoneyAmount(int n) {
		dp=new int[n+1][n+1];
		return cost(1,n,n);
	}

	public static int cost(int start, int end,int n) {
		if(start>=end)
			return 0;
		if(dp[start][end]!=0)
			return dp[start][end];
		int ans=Integer.MAX_VALUE;
		for(int i=start;i<end;i++) {
			int temp=i+Math.max(cost(start,i-1,n),cost(i+1,end,n));
			if(temp<=ans)
				ans=temp;
		}
		dp[start][end]=ans;
		return ans;
	}
	public static void main(String[] args) {
		System.out.println(getMoneyAmount(4));
	}
	
}
