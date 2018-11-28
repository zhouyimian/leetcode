package com.km.leetcode;

import java.util.*;

public class Combination_Sum {
	static Set<List<Integer>> set=new HashSet<>();
	static List<List<Integer>> ans=new ArrayList<>();
	static int[] coins;
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		coins=candidates;
		Arrays.sort(coins);
		dfs(target,new ArrayList<Integer>(),0);
		ans.addAll(set);
		return ans;
	}
	static void dfs(int target,List<Integer> list,int start) {
		if(target<0)
			return;
		else {
			for(int i=start;i<coins.length;i++) {
				if(target>coins[i]) {
					list.add(coins[i]);
					dfs(target-coins[i],list,i);
					list.remove(list.size()-1);
				}
				else if(target==coins[i]) {
					List<Integer> temp=new ArrayList<>(list);
					temp.add(coins[i]);
					Collections.sort(temp);
					set.add(temp);
					return;
				}
				else {
					return;
				}
			}
		}
	}
	public static void main(String[] args) {
		int[] n= {2,3,6,7};
		combinationSum(n,7);
	}
}
