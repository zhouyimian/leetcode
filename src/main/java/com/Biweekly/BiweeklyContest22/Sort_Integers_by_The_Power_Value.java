package com.Biweekly.BiweeklyContest22;

import java.util.*;

public class Sort_Integers_by_The_Power_Value {
    public int getKth(int lo, int hi, int k) {
        List<Integer> nums = new ArrayList<>();
        TreeMap<Integer,List<Integer>> map = new TreeMap<>(Comparator.comparingInt(o -> o));
        for(int i = lo;i<=hi;i++){
            int count = deal(i);
            List<Integer> list = map.getOrDefault(count,new ArrayList<>());
            list.add(i);
            map.put(count,list);
        }
        for(Map.Entry<Integer,List<Integer>> entry:map.entrySet()){
            List<Integer> values = entry.getValue();
            if(k>values.size()){
                k-=values.size();
            }else{
                Collections.sort(values);
                return values.get(k-1);
            }
        }
        return -1;
    }

    private int deal(int num) {
        int ans = 0;
        while (num!=1){
            ans++;
            if(num%2==0){
                num/=2;
            }else{
                num = (num*3)+1;
            }
        }
        return ans;
    }
}
