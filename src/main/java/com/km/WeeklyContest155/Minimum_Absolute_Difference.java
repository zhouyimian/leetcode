package com.km.WeeklyContest155;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Minimum_Absolute_Difference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int min_diff = Integer.MAX_VALUE;
        for(int i = 1;i<arr.length;i++){
            if(arr[i]-arr[i-1]<min_diff){
                min_diff = arr[i]-arr[i-1];
            }
        }
        for(int i = 1;i<arr.length;i++){
            if(arr[i]-arr[i-1]==min_diff){
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i-1]);
                temp.add(arr[i]);
                ans.add(temp);
            }
        }
        return ans;
    }
}
