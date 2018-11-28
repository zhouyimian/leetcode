package com.km.leetcode;

import java.util.*;

public class LFUCache {
	Map<Integer,Integer> map;
	Map<Integer,Integer> time;
	int size;
	int nowsize=0;
	public LFUCache(int capacity) {
		size=capacity;
		map=new LinkedHashMap<>();
		time=new LinkedHashMap<>();
	}
	public int get(int key) {
		if(map.containsKey(key)) {
			int val=map.get(key);
			map.remove(key);
			map.put(key, val);
			time.put(key, time.get(key)+1);
			return map.get(key);
		}
		else
			return -1;
	}
	public void put(int key, int value) {
		if (nowsize == size) {
			if (size == 0) {
				return;
			} else if(map.containsKey(key)){
				time.put(key, time.get(key)+1);
				map.put(key, value);
			}
			else {
				Iterator it = map.keySet().iterator();
				int minkey = 0;
				int min=Integer.MAX_VALUE;
				while(it.hasNext()) {
					int k=(int) it.next();
					int v=time.get(k);
					if(v<min) {
						min=v;
						minkey=k;
					}
				}
				map.remove(minkey);
				time.remove(minkey);
				map.put(key, value);
				time.put(key, 1);
			}
		}
		else {
			if(map.containsKey(key)) {
				time.put(key, time.get(key)+1);
				map.put(key, value);
			}
			else {
				map.put(key, value);
				time.put(key, 1);
				nowsize++;
			}
		}
	}
	public static void main(String[] args) {
		LFUCache s=new LFUCache(2);
		s.put(2, 1);
		s.put(3, 2);
		System.out.println(s.get(3));
		System.out.println(s.get(2));
		s.put(4, 3);
		System.out.println(s.get(2));
		System.out.println(s.get(3));
		System.out.println(s.get(4));
	}
}
