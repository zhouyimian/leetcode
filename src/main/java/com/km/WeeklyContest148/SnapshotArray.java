package com.km.WeeklyContest148;

import java.util.HashMap;
import java.util.Map;

public class SnapshotArray {
    Map<Integer,Map<Integer,Integer>> map;
    int length;
    int snapCount = 0;
    public SnapshotArray(int length) {
        map = new HashMap<>();
        this.length = length;
    }

    public void set(int index, int val) {
        Map<Integer,Integer> cur = map.getOrDefault(snapCount,new HashMap<>());
        cur.put(index,val);
        map.put(snapCount,cur);
    }

    public int snap() {
        if(map.get(snapCount)==null)
            map.put(snapCount,new HashMap<>());
        return snapCount++;
    }

    public int get(int index, int snap_id) {
        for(int i = snap_id;i>=0;i--){
            Map<Integer,Integer> before = map.get(i);
            if(before.get(index)!=null)
                return before.get(index);
        }
        return 0;
    }

    public static void main(String[] args) {
        SnapshotArray test = new SnapshotArray(1);
        test.set(0,15);
        test.snap();
        test.snap();
        test.snap();
        System.out.println(test.get(0,2));
        test.snap();
        test.snap();
        System.out.println(test.get(0,0));

    }
}
//["SnapshotArray","set","snap","snap","snap","get","snap","snap","get"]
//[[1],[0,15],[],[],[],[0,2],[],[],[0,0]]