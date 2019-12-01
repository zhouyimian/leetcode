package com.km.WeeklyContest165;

public class Count_Square_Submatrices_with_All_Ones {
    public int countSquares(int[][] matrix) {
        int ans = 0;
        int[][] sum = new int[matrix.length+1][matrix[0].length+1];
        for(int i = 1;i<=matrix.length;i++){
            for(int j = 1;j<=matrix[0].length;j++){
                sum[i][j] = sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+matrix[i-1][j-1];
            }
        }
        ans+=sum[matrix.length][matrix[0].length];
        int length = Math.min(matrix.length,matrix[0].length);
        for(int size = 2;size<=length;size++){
            for(int i = size;i<=matrix.length;i++){
                for(int j = size;j<=matrix[0].length;j++){
                    if(size*size==(sum[i][j]-sum[i][j-size]-sum[i-size][j]+sum[i-size][j-size]))
                        ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][]nums = {{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        Count_Square_Submatrices_with_All_Ones test = new Count_Square_Submatrices_with_All_Ones();
        System.out.println(test.countSquares(nums));
    }
}