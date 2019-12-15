package com.km.WeeklyContest167;

public class Maximum_Side_Length_of_a_Square_with_Sum_Less_than_or_Equal_to_Threshold {
    public int maxSideLength(int[][] mat, int threshold) {
        int ans = 0;
        int[][] sum = new int[mat.length+1][mat[0].length+1];
        for(int i = 1;i<=mat.length;i++){
            for(int j = 1;j<=mat[0].length;j++){
                sum[i][j] = sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+mat[i-1][j-1];
            }
        }
        int length = Math.min(mat.length,mat[0].length);
        for(int size = 1;size<=length;size++){
            for(int i = size;i<=mat.length;i++){
                for(int j = size;j<=mat[0].length;j++){
                    if((sum[i][j]-sum[i][j-size]-sum[i-size][j]+sum[i-size][j-size])<=threshold)
                        ans = Math.max(ans,size);
                }
            }
        }
        return ans;
    }
}
