package com.km.leetcode;

import java.util.ArrayList;
import java.util.List;

public class All_Paths_From_Source_to_Target {
	List<List<Integer>> ans=new ArrayList<>();
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		for(int i=0;i<graph[0].length;i++) {
			List<Integer> list=new ArrayList<>();
			list.add(0);
			list.add(graph[0][i]);
			dfs(graph[0][i],list,graph);
			list.clear();
		}
		return ans;
	}
	public void dfs(int now, List<Integer> list,int[][] graph) {
		if(now==graph.length-1) {
			List<Integer> temp=new ArrayList<>(list);
			ans.add(temp);
			return;
		}
		else {
			for(int i=0;i<graph[now].length;i++) {
				list.add(graph[now][i]);
				dfs(graph[0][i],list,graph);
				list.remove(list.size()-1);
			}
		}
	}
}
