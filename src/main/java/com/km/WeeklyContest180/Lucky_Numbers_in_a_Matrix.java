package com.km.WeeklyContest180;

import java.util.ArrayList;
import java.util.List;

public class Lucky_Numbers_in_a_Matrix {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return ans;
        for(int i = 0;i<matrix.length;i++){
            int min_index = 0;
            boolean flag = true;
            for(int j = 0;j<matrix[i].length;j++){
                if(matrix[i][j]<matrix[i][min_index]){
                    min_index = j;
                }
            }
            for(int j = 0;j<matrix.length;j++){
                if(matrix[j][min_index]>matrix[i][min_index]) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                ans.add(matrix[i][min_index]);
        }
        return ans;
    }
}
