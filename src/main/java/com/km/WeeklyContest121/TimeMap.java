package com.km.WeeklyContest121;

import java.util.HashMap;
import java.util.TreeMap;

public class TimeMap {
    HashMap<String,TreeMap<Integer,String>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap treeMap = map.get(key);
        if(null == treeMap)
            treeMap = new TreeMap<Integer,String>();
        treeMap.put(timestamp,value);
        map.put(key,treeMap);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer,String> treeMap = map.get(key);
        if(null == treeMap)
            return "";
        Integer floorkey = treeMap.floorKey(timestamp);
        if(null == floorkey)
            return "";
        return treeMap.get(floorkey);
    }

    public static void main(String[] args) {
        TimeMap test = new TimeMap();
        test.set("foo","bar",1);
        System.out.println(test.get("foo",1));
    }
}
