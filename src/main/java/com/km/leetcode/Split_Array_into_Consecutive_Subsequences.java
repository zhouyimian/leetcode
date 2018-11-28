package com.km.leetcode;

import java.util.HashMap;

public class Split_Array_into_Consecutive_Subsequences {
	public static boolean isPossible(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		HashMap<Integer, Integer> needmap = new HashMap<>();
		for (int num : nums)
			map.put(num, map.getOrDefault(num, 0) + 1);
		for (int num : nums) {
			if (map.get(num) <= 0) {
				continue;
			} else if (needmap.getOrDefault(num, 0) > 0) {
				needmap.put(num + 1, needmap.getOrDefault(num + 1, 0) + 1);
				needmap.put(num, needmap.getOrDefault(num, 0) - 1);
			} else if (map.getOrDefault(num + 1,0) > 0 && map.getOrDefault(num + 2,0) > 0) {
				map.put(num + 1, map.get(num + 1) - 1);
				map.put(num + 2, map.get(num + 2) - 1);
				needmap.put(num + 3, needmap.getOrDefault(num + 3, 0) + 1);
			} else
				return false;
			map.put(num, map.get(num) - 1);
		}
		return true;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 4, 5 };
		System.out.println(isPossible(nums));
	}
}
