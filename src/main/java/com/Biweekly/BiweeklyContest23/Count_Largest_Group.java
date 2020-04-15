package com.Biweekly.BiweeklyContest23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Count_Largest_Group {
    public int countLargestGroup(int n) {
        int ans = 0;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 1;i<=n;i++){
            int sum = cal(i);
            List<Integer> list = map.getOrDefault(sum,new ArrayList<>());
            list.add(i);
            map.put(sum,list);
        }
        int max = 0;
        for(Map.Entry<Integer,List<Integer>> entry:map.entrySet()){
            int value = entry.getValue().size();
            if(value>max)
                max = value;
        }
        for(Map.Entry<Integer,List<Integer>> entry:map.entrySet()){
            int value = entry.getValue().size();
            if(value==max)
                ans++;
        }
        return ans;
    }

    private int cal(int num) {
        int sum = 0;
        while (num!=0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
}
