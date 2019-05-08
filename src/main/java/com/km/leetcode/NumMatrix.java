package com.km.leetcode;

public class NumMatrix {
    int[][] sum;
    public NumMatrix(int[][] matrix) {
        sum = new int[matrix.length+1][matrix[0].length+1];
        sum[1][1] = matrix[0][0];
        for(int i = 2;i<=matrix.length;i++)
            sum[i][1] = sum[i-1][1] + matrix[i-1][0];
        for(int i = 2;i<=matrix[0].length;i++)
            sum[1][i] = sum[1][i-1] + matrix[0][i-1];
        for(int i = 2;i<=matrix.length;i++){
            for(int j = 2;j<=matrix[0].length;j++){
                sum[i][j] = sum[i-1][j] + sum[i][j-1]-sum[i-1][j-1]+matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2+1][col2+1] - sum[row2+1][col1] - sum[row1][col2+1]+sum[row1][col1];
    }

    public static void main(String[] args) {
        int[][] nums = {{1},{-7}};
        NumMatrix test = new NumMatrix(nums);
    }
}
