package com.km.WeeklyContest157;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Longest_Arithmetic_Subsequence_of_Given_Difference {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int max = 0;
        for(int i=0;i<arr.length;i++){
            int count = hm.getOrDefault(arr[i],0) +1;
            if(count>max) max = count;
            hm.put(arr[i]+difference,count);
        }
        return max;
    }
}
