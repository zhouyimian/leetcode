package com.km.WeeklyContest166;

import java.util.*;

public class Group_the_People_Given_the_Group_Size_They_Belong_To {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int length = groupSizes.length;
        for(int i = 0;i<length;i++){
            List<Integer> list = map.get(groupSizes[i]);
            if(list==null)
                list = new ArrayList<>();
            list.add(i);
            map.put(groupSizes[i],list);
        }
        List<List<Integer>> ans = new ArrayList<>();
        Iterator<Integer> it = map.keySet().iterator();
        while(it.hasNext()){
            Integer key = it.next();
            List<Integer> list = map.get(key);
            int cur = 0;
            for(int i = 0;i<list.size()/key;i++){
                List<Integer> temp = new ArrayList<>();
                for(int j = cur;j<cur+key;j++){
                    temp.add(list.get(j));
                }
                cur+=key;
                ans.add(temp);
            }
        }
        return ans;

    }
}
