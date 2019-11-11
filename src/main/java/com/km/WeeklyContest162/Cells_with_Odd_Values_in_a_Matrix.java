package com.km.WeeklyContest162;

public class Cells_with_Odd_Values_in_a_Matrix {
    public int oddCells(int n, int m, int[][] indices) {
        int ans = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                int count = 0;
                for(int k = 0;k<indices.length;k++){
                    if(indices[k][0]==i)
                        count++;
                    if(indices[k][1]==j)
                        count++;
                }
                if(count%2==1)
                    ans++;
            }
        }
        return ans;
    }
}
