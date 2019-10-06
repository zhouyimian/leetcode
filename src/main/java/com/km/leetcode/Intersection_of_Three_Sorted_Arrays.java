package com.km.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Intersection_of_Three_Sorted_Arrays {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();
        for(int num:arr2)
            set2.add(num);
        for(int num:arr3)
            set3.add(num);
        for(int num:arr1){
            if(set2.contains(num)&&set3.contains(num))
                ans.add(num);
        }
        return ans;
    }
}
