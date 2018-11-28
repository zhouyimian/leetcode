package com.km.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class RecentCounter {
	TreeSet<Integer> set;
	Map<Integer, Integer> map;

	public RecentCounter() {
		set = new TreeSet<>();
		map = new HashMap<>();
	}

	public int ping(int t) {
		set.add(t);
		map.put(t, set.size());
		if (t <= 3000) {
			return set.size();
		} else {
			Integer temp = set.lower(t - 3000);
			if (temp == null) {
				return set.size();
			} else {
				map.put(t, set.size());
				return set.size() - map.get(temp);
			}
		}
	}

	public static void main(String[] args) {

	}
}
