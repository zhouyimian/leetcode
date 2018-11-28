package com.km.leetcode;

public class Friend_Circles {
	int[] graph;
	public int findCircleNum(int[][] M) {
		graph=new int[M.length];
		for(int i=0;i<graph.length;i++) {
			graph[i]=i;
		}
		int ans = M.length;
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < i; j++) {
				if(M[i][j]==1){
					int parent_from = find(i);
					int parent_to = find(j);
					if (parent_from != parent_to) {
						ans--;
						graph[parent_from] = parent_to;
					}
				}
			}
		}
		return ans;
	}
	int find(int num) {
		while(num!=graph[num]) {
			num=graph[num];
		}
		return num;
	}
}
