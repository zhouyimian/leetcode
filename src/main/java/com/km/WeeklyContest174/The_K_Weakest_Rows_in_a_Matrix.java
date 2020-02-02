package com.km.WeeklyContest174;

import java.util.HashSet;
import java.util.Set;

public class The_K_Weakest_Rows_in_a_Matrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] ans = new int[k];
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for(int i = 0;i<mat[0].length;i++){
            if(count==k)
                break;
            for(int j = 0;j<mat.length;j++){
                if(count==k)
                    break;
                    if(mat[j][i]==0&&!set.contains(j)) {
                        set.add(j);
                        ans[count] = j;
                        count++;
                    }
            }
        }
        if(count!=k){
            for(int i = 0;i<mat.length;i++){
                if(!set.contains(i)&&count!=k){
                    ans[count]=i;
                    count++;
                }
            }
        }
        return ans;
    }
}
