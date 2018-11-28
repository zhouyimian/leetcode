package com.km.leetcode;

import java.util.Arrays;

public class Coin_Change {
	public static int coinChange(int[] coins, int amount) {
		if(amount==0)
			return 0;
		int[] dp=new int[amount+1];
		for(int i=1;i<=amount;i++) {
			for(int j=0;j<coins.length;j++) {
				if(i<coins[j])
					continue;
				if(dp[i]==0) {
					if(dp[i-coins[j]]!=0||i-coins[j]==0) {
						dp[i]=dp[i-coins[j]]+1;
					}
				}
				else {
					if(dp[i-coins[j]]!=0||i-coins[j]==0)
						dp[i]=Math.min(dp[i], dp[i-coins[j]]+1);
					
				}
			}
		}
		return dp[amount]==0?-1:dp[amount];
	}
	public static void main(String[] args) {
		int[] c= {1,2};
		System.out.println(coinChange(c,2));
	}
}
