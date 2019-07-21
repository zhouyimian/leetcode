package com.km.leetcode;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] nums = new int[size][size];
        int[][] dp = new int[size][size];
        for(int i = 0;i<size;i++){
            for(int j = 0;j<=i;j++){
                nums[i][j] = triangle.get(i).get(j);
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = nums[0][0];
        for(int i = 1;i<size;i++){
            for(int j = 0;j<=i;j++){
                if(i>=j)
                    dp[i][j] = Math.min(dp[i][j],nums[i][j]+dp[i-1][j-1]);
                if(i-1>=j)
                    dp[i][j] = Math.min(dp[i][j],nums[i][j]+dp[i-1][j]);
                if(i-2>=j)
                    dp[i][j] = Math.min(dp[i][j],nums[i][j]+dp[i-1][j+1]);
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<size;i++){
            ans = Math.min(dp[size-1][i],ans);
        }
        return ans;
    }
}
