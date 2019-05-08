package com.km.WeeklyContest135;

public class Minimum_Score_Triangulation_of_Polygon {
    public int minScoreTriangulation(int[] A) {
        int length = A.length;
        int[][] dp = new int[length][length];
        for(int d = 2;d<length;d++){
            for(int i = 0;i+d<length;i++){
                int j = d+i;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i+1;k<j;k++){
                    dp[i][j] = Math.min(dp[i][j],dp[i][k]+dp[k][j]+A[i]*A[j]*A[k]);
                }
            }
        }
        return dp[0][length-1];
    }
}
