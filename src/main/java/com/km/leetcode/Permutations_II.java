package com.km.leetcode;

import java.util.*;

public class Permutations_II {
	static Set<List<Integer>> set=new HashSet<>();
	static Map<Integer,Integer> map=new HashMap<>();
	static int[] n;
	public static List<List<Integer>> permuteUnique(int[] nums) {
		n=nums;
		for(int i=0;i<nums.length;i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		}
		dfs(new ArrayList<Integer>(),0);
		return new ArrayList<>(set);
	}
	static void dfs(List<Integer> list,int count) {
		if(count==n.length) {
			List<Integer> temp=new ArrayList<>(list);
			set.add(temp);
			return;
		}
		for(int i=0;i<map.size();i++) {
			Iterator it=map.keySet().iterator();
			int j=0;
			while(j<i) {
				it.next();
				j++;
			}
			int key=(int) it.next();
			int value=map.get(key);
			if(value==0)
				continue;
			else
				map.put(key, value-1);
			list.add(key);
			dfs(list,count+1);
			list.remove(list.size()-1);
			map.put(key, map.getOrDefault(key, 0)+1);
		}
	}
	public static void main(String[] args) {
		int[] n= {-1,3,0,3};
		permuteUnique(n);
	}
}
