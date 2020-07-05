package com.km.WeeklyContest196;

public class Count_Submatrices_With_All_Ones {
    public int numSubmat(int[][] mat) {
        int ans = 0;
        int[][] sum = new int[mat.length+1][mat[0].length+1];
        for(int i = 0;i<mat.length;i++){
            for(int j = 0;j<mat[0].length;j++){
                sum[i+1][j+1] = sum[i+1][j]+sum[i][j+1]-sum[i][j]+mat[i][j];
            }
        }
        ans = sum[mat.length][mat[0].length];
        for(int row = 1;row<=mat.length;row++){
            for(int column = 1;column<=mat[0].length;column++){
                for(int i = 1;i+row-1<sum.length;i++){
                    for(int j = 1;j+column-1<sum[0].length;j++){
                        if(row==1&&column==1)
                            continue;
                        if(sum[i+row-1][j+column-1]-sum[i+row-1][j-1]-sum[i-1][j+column-1]+sum[i-1][j-1]==row*column)
                            ans++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = {{0,1,1,0},{0,1,1,1},{1,1,1,0}};
        Count_Submatrices_With_All_Ones test = new Count_Submatrices_With_All_Ones();
        System.out.println(test.numSubmat(nums));
    }
}
