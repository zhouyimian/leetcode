package com.km.WeeklyContest139;

public class Flip_Columns_For_Maximum_Number_of_Equal_Rows {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int ans = 0;
        int length = matrix.length;
        int[][] diff = new int[length][length];
        for(int i = 0;i<length;i++){
            for(int j = 0;j<length;j++){
                if(i==j) continue;
                else
                    diff[i][j] = deal(i,j,matrix);
            }
        }
        for(int i = 0;i<length;i++){
            int temp = 0;
            for(int j = 0;j<length;j++){
                if(diff[i][j]==0||diff[i][j]==matrix[0].length)
                    temp++;
            }
            ans = Math.max(ans,temp);
        }
        return ans;
    }

    private int deal(int first, int second, int[][] matrix) {
        int diff = 0;
        for(int i = 0;i<matrix[0].length;i++){
            if(matrix[first][i]!=matrix[second][i])
                diff++;
        }
        return diff;
    }

    public static void main(String[] args) {
        Flip_Columns_For_Maximum_Number_of_Equal_Rows test = new Flip_Columns_For_Maximum_Number_of_Equal_Rows();
        int[][] nums = {{0,1},{1,1}};
        System.out.println(test.maxEqualRowsAfterFlips(nums));
    }
}
