package com.km.leetcode;

import java.util.Arrays;

public class Coin_Change_2 {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;

        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }

    public static void main(String[] args) {
        int[] coins={3,5,7,8,9,10,11};
        Coin_Change_2 test=new Coin_Change_2();
        System.out.println(test.change(500,coins));
    }
}
