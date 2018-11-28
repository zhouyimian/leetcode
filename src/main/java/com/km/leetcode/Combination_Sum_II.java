package com.km.leetcode;

import java.util.*;

public class Combination_Sum_II {
	Set<List<Integer>> ans=new HashSet<>();
	int tar;
	int[] nums;
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		if(candidates.length==0)
			return new ArrayList<List<Integer>>();
		tar=target;
		nums=candidates;
		Arrays.sort(candidates);
		dfs(0,0,new ArrayList<Integer>());
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		list.addAll(ans);
		return list;
	}
	void dfs(int start,int sum,List<Integer> list) {
		if(sum==tar) {
			List<Integer> temp=new ArrayList<>();
			temp.addAll(list);
			ans.add(temp);
			return;
		}
		for(int i=start;i<nums.length;i++) {
			if(sum+nums[i]>tar) {
				return;
			}
			else {
				list.add(nums[i]);
				dfs(i+1,sum+nums[i],list);
				list.remove(list.size()-1);
			}
		}
	}
}
