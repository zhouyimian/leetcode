package com.km.WeeklyContest182;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Find_Lucky_Integer_in_an_Array {
    public int findLucky(int[] arr) {
        int ans = -1;
        Map<Integer,Integer> map = new TreeMap<>();
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            if(key==value)
                ans = value;
        }
        return ans;
    }
}
