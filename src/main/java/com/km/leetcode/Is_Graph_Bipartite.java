package com.km.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Is_Graph_Bipartite {
	List<List> map=new ArrayList<>();
	int[] color = new int[110];
	public boolean isBipartite(int[][] graph) {
		for (int i = 0; i < graph.length; i++) {
			List<Integer> list=new ArrayList<>();
			for (int j = 0; j < graph[i].length; j++) {
				list.add(graph[i][j]);
			}
			map.add(list);
		}
		for(int i=0;i<graph.length;i++) {
			if(color[i]==0) {
				color[i]=1;
				if(!dfs(i))
					return false;
			}
		}
		return true;
	}

	public boolean dfs(int now) {
		List<Integer> list=map.get(now);
		for(int i=0;i<list.size();i++) {
			if(color[list.get(i)]==color[now])
				return false;
			else if(color[list.get(i)]==0) {
				color[list.get(i)]=color[now]==1?2:1;
				if(!dfs(list.get(i)))
					return false;
			}
		}
		return true;
	}
}
