package com.km.WeeklyContest162;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reconstruct_a_2_Row_Binary_Matrix {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> ans = new ArrayList<>();
        int count = 0;
        Integer[][] nums = new Integer[2][colsum.length];
        Arrays.fill(nums[0],0);
        Arrays.fill(nums[1],0);
        int[][] canVisitCount = new int[2][colsum.length];
        for (int num : colsum)
            count += num;
        if (count != upper + lower) {
            return ans;
        } else {
            for (int i = 0; i < colsum.length; i++) {
                if (colsum[i] == 2) {
                    nums[0][i] = 1;
                    nums[1][i] = 1;
                    lower--;
                    upper--;
                }
            }
            count = 0;
            for (int i = colsum.length - 1; i >= 0; i--) {
                if (colsum[i] == 1)
                    canVisitCount[0][i] = ++count;
            }
            count = 0;
            for (int i = colsum.length - 1; i >= 0; i--) {
                if (colsum[i] == 1)
                    canVisitCount[1][i] = ++count;
            }
            if(count!=upper+lower||upper<0||lower<0)
                return ans;
            for(int i = 0;i<colsum.length;i++){
                if(colsum[i]==1){
                    if(upper!=0){
                        nums[0][i] = 1;
                        upper--;
                    }else if(lower!=0){
                        nums[1][i] = 1;
                        lower--;
                    }
                }
            }
            ans.add(Arrays.asList(nums[0]));
            ans.add(Arrays.asList(nums[1]));
        }
        return ans;
    }

    public static void main(String[] args) {
        Reconstruct_a_2_Row_Binary_Matrix test = new Reconstruct_a_2_Row_Binary_Matrix();
        int[] nums= {0,1,2,0,0,0,0,0,2,1,2,1,2};
        System.out.println(test.reconstructMatrix(9,2,nums).get(0));
        //System.out.println(test.reconstructMatrix(2,1,nums).get(1));
    }
}
//9
//2
//[0,1,2,0,0,0,0,0,2,1,2,1,2]