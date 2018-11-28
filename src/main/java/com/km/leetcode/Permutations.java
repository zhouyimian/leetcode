package com.km.leetcode;

import java.util.*;

public class Permutations {
	/*static Set<List<Integer>> set = new HashSet<>();
	static List<List<Integer>> ans = new ArrayList<>();
	static int[] vis;

	public static List<List<Integer>> permute(int[] nums) {
		vis = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			vis[i] = 1;
			List<Integer> temp = new ArrayList<>();
			temp.add(nums[i]);
			dfs(temp, 1, i, nums);
			vis[i] = 0;
			temp.remove(temp.size() - 1);
		}
		ans.addAll(set);
		return ans;
	}

	static void dfs(List<Integer> list, int count, int pos, int[] nums) {
		if (pos == nums.length && count == nums.length) {
			List<Integer> temp = new ArrayList<>();
			temp.addAll(list);
			set.add(temp);
			return;
		}
		if (pos == nums.length && count != nums.length) {
			for (int i = 0; i < nums.length; i++) {
				if (vis[i] == 0) {
					list.add(nums[i]);
					vis[i] = 1;
					dfs(list, count + 1, pos, nums);
					vis[i] = 0;
					list.remove(list.size() - 1);
				}
			}
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (vis[i] == 0) {
					list.add(nums[i]);
					vis[i] = 1;
					dfs(list, count + 1, i + 1, nums);
					vis[i] = 0;
					list.remove(list.size() - 1);
				}
			}
			dfs(list, count, pos + 1, nums);
		}
	}

	public static void main(String[] args) {
		int[] n = { 1, 2, 3 };
		System.out.println(permute(n).size());
	}
}*/
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		// Arrays.sort(nums); // not necessary
		backtrack(list, new ArrayList<>(), nums);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
		if (tempList.size() == nums.length) {
			list.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (tempList.contains(nums[i]))
					continue; // element already exists, skip
				tempList.add(nums[i]);
				backtrack(list, tempList, nums);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
