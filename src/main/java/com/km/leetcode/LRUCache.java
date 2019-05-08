package com.km.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private LinkedHashMap<Integer, Integer> cache;
    private int capacity;

    public LRUCache(int capacity) {

        this.cache = new LinkedHashMap<Integer, Integer>(16,0.75f,true){

            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return  cache.size() > capacity;
            }
        };
        this.capacity = capacity;
    }

    public int get(int key) {
        int value = cache.getOrDefault(key, -1);
        return value;
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
