package com.km.WeeklyContest176;

public class Count_Negative_Numbers_in_a_Sorted_Matrix {
    public int countNegatives(int[][] grid) {
        int ans = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                if(grid[i][j]<0)
                    ans++;
            }
        }
        return ans;
    }
}
