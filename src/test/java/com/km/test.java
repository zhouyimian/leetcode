package com.km;

import java.util.*;

public class test {
    public int findNumberOfLIS(int[] nums) {
        int ans = 0;
        int[]dp = new int[nums.length];
        Arrays.fill(dp,1);
        int length = nums.length;
        int maxLength = 1;
        for(int i = 1;i<length;i++){
            for(int j = 0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    maxLength = Math.max(maxLength,dp[i]);
                }
            }
        }
        if(maxLength==1) return length;
        int[][] newDp = new int[length][maxLength+1];
        for(int i = 0;i<length;i++){
            newDp[i][1] = 1;
        }
        for(int i = 0;i<length;i++){
            for(int j = 0;j<i;j++){
                if(nums[j]<nums[i]){
                    for(int k = 1;k<=maxLength;k++){
                        newDp[i][k]+= newDp[j][k-1];
                    }
                }
            }
        }
        for(int i = 0;i<length;i++)
            ans+=newDp[i][maxLength];
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        test t = new test();
        System.out.println(t.findNumberOfLIS(nums));
    }
}
