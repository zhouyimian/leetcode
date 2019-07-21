package com.km.WeeklyContest145;

import java.util.*;

public class Relative_Sort_Array {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> map = new TreeMap<>();
        for(int num:arr1){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Integer> temp = new ArrayList<>();
        for(int num:arr2){
            int count = map.getOrDefault(num,0);
            for(int i = 0;i<count;i++){
                temp.add(num);
            }
            map.remove(num);
        }
        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()){
            int key = it.next();
            int value = map.get(key);
            for(int i = 0;i<value;i++)
                temp.add(key);
        }
        int[] ans = new int[temp.size()];
        for(int i = 0;i<ans.length;i++)
            ans[i] = temp.get(i);
        return ans;
    }
}
