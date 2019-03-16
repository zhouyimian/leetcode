package com.km.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Rabbits_in_Forest {
    public int numRabbits(int[] answers) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:answers)
            map.put(num,map.getOrDefault(num,0)+1);
        Iterator<Integer> iterator = map.keySet().iterator();
        int ans = answers.length;
        while(iterator.hasNext()){
            int key = iterator.next();
            int value = map.get(key);
            ans+=value%(key+1)==0?0:(key+1-(value%(key+1)));
        }
        return ans;
    }
}
