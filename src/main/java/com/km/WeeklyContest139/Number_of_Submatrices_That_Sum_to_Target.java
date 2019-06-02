package com.km.WeeklyContest139;

import java.util.HashMap;
import java.util.Map;

public class Number_of_Submatrices_That_Sum_to_Target {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans = 0;
        int line = matrix.length;
        int column = matrix[0].length;
        for(int left = 0;left<column;left++){
            int[] sum = new int[line];
            for(int right = left;right<column;right++){
                for(int k = 0;k<line;k++){
                    sum[k]+=matrix[k][right];
                }
                ans+=deal(sum,target);
            }
        }
        return ans;
    }

    private int deal(int[] sum, int target) {
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int curSum = 0;
        for(int num:sum){
            curSum+=num;
            if(curSum==target)
                ans++;
            if(map.containsKey(curSum-target))
                ans+=map.get(curSum-target);
            map.merge(curSum,1,(a,b)->a+b);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = {{0,1,0},{1,1,1},{0,1,0}};
        Number_of_Submatrices_That_Sum_to_Target test = new Number_of_Submatrices_That_Sum_to_Target();
        System.out.println(test.numSubmatrixSumTarget(nums,0));
    }
}