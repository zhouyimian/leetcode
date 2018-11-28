package com.km.WeeklyContest110;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Minimum_Area_Rectangle {
	public int minAreaRect(int[][] points) {
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int[] p : points) {
			if (!map.containsKey(p[0])) {
				map.put(p[0], new HashSet<>());
			}
			map.get(p[0]).add(p[1]);
		}
		int min = Integer.MAX_VALUE;
		for (int[] p1 : points) {
			for (int[] p2 : points) {
				if (p1[0] == p2[0] || p1[1] == p2[1]) {
					continue;
				}
				if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) {
					min = Math.min(min, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
				}
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}

	public static void main(String[] args) {
		Minimum_Area_Rectangle test = new Minimum_Area_Rectangle();
		int[][] nums = { { 0, 1 }, { 1, 3 }, { 3, 3 }, { 4, 4 }, { 1, 4 }, { 2, 3 }, { 1, 0 }, { 3, 4 } };
		System.out.println(test.minAreaRect(nums));
	}
	// [[0,1],[1,3],[3,3],[4,4],[1,4],[2,3],[1,0],[3,4]]
}
