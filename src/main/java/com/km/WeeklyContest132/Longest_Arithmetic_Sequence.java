package com.km.WeeklyContest132;

import java.util.Arrays;

public class Longest_Arithmetic_Sequence {
    public int longestArithSeqLength(int[] A) {
        int[][] dp = new int[A.length][10001];
        int ans = 0;
        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp[i].length;j++){
                dp[i][j] = 1;
            }
        }
        for(int i = 1;i<A.length;i++){
            for(int j = 0;j<i;j++){
                if(A[i]-A[j]>=0){
                    dp[i][A[i]-A[j]] = Math.max(dp[i][A[i]-A[j]],dp[j][A[i]-A[j]]+1);
                    ans = Math.max(ans,dp[i][A[i]-A[j]]);
                }
            }
        }
        for(int i = 0;i<A.length;i++){
            A[i] = -A[i];
        }
        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp[i].length;j++){
                dp[i][j] = 1;
            }
        }
        for(int i = 1;i<A.length;i++){
            for(int j = 0;j<i;j++){
                if(A[i]-A[j]>=0){
                    dp[i][A[i]-A[j]] = Math.max(dp[i][A[i]-A[j]],dp[j][A[i]-A[j]]+1);
                    ans = Math.max(ans,dp[i][A[i]-A[j]]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3,6,9,12};
        Longest_Arithmetic_Sequence test = new Longest_Arithmetic_Sequence();
        System.out.println(test.longestArithSeqLength(nums));
    }
}
