package com.km.WeeklyContest114;

import java.util.HashMap;
import java.util.Map;

public class Tallest_Billboard {
    public int tallestBillboard(int[] rods) {
        Map<Integer,Integer> map=new HashMap<>(),cur;
        map.put(0,0);
        for(int num:rods){
            cur=new HashMap<>(map);
            for(int d:cur.keySet()){
                map.put(d+num,Math.max(cur.get(d),map.getOrDefault(num+d,0)));
                map.put(Math.abs(d-num),Math.max(cur.get(d)+Math.min(d,num),map.getOrDefault(Math.abs(d-num),0)));
            }
        }
        return map.get(0);
    }
}
