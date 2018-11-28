package com.km.leetcode;

public class Redundant_Connection {
	int[] parent=new int[2010];
	public int[] findRedundantConnection(int[][] edges) {
		int[] ans=new int[2];
		for(int i=1;i<parent.length;i++) {
			parent[i]=i;
		}
		int point1,point2;
		for(int i=0;i<edges.length;i++) {
			point1=findparent(edges[i][0]);
			point2=findparent(edges[i][1]);
			if(point1==point2) {
				ans[0]=edges[i][0];
				ans[1]=edges[i][1];
				return ans;
			}
			parent[point1]=point2;
		}
		return null;
	}
	int findparent(int i) {
		while(i!=parent[i]) {
			i=parent[i];
		}
		return i;
	}
}
