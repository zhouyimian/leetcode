package com.km.leetcode;

import java.util.ArrayList;
import java.util.List;

public class House_Robber_II {
    public int rob(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        int num1 = rob(nums,0,nums.length-2);
        int num2 = rob(nums,1,nums.length-1);
        return Math.max(rob(nums,0,nums.length-2),rob(nums,1,nums.length-1));
    }
    public int rob(int[] nums,int start,int end) {
        int[][] dp=new int[nums.length][2];
        dp[start][0]=0;
        dp[start][1]=nums[start];
        for(int i=start+1;i<=end;i++) {
            dp[i][0]=Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1]=dp[i-1][0]+nums[i];
        }
        return Math.max(dp[end][0], dp[end][1]);
    }
    public static void main(String[] args) {
        int[] nums = {1,2};
        House_Robber_II test = new House_Robber_II();
        System.out.println(test.rob(nums));
    }
}
