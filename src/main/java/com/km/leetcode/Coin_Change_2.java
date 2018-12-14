package com.km.leetcode;

import java.util.Arrays;

public class Coin_Change_2 {
    int ans=0;
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        if(amount==0)
            return 1;
        dfs(amount,0,coins);
        return ans;
    }

    private void dfs(int amount, int nowcoin,int[] coins) {
        if(amount==0){
            ans++;
            return;
        }
        if(nowcoin>=coins.length||amount<coins[nowcoin])
            return;
        for(int i=0;i<=amount/coins[nowcoin];i++)
            dfs(amount-coins[nowcoin]*i,nowcoin+1,coins);
    }

    public static void main(String[] args) {
        int[] coins={1,2,5};
        Coin_Change_2 test=new Coin_Change_2();
        System.out.println(test.change(5,coins));
    }
}
