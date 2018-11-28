package com.km.WeeklyContest87;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Shortest_Path_Visiting_All_Nodes {
	static int ans = Integer.MAX_VALUE;
	static Set<Integer> visit = new HashSet<>();
	static int[][] my_graph;
	static List<ArrayList<HashSet<Integer>>> list = new ArrayList<>();

	public static int shortestPathLength(int[][] graph) {
		my_graph = new int[graph.length][graph.length];
		for (int i = 0; i < graph.length;i++) {
			list.add(new ArrayList<>());
			for (int j = 0; j < graph.length;j++) {
				list.get(i).add(new HashSet<>());
			}
		}
		for (int i = 0; i < graph.length; i++)
			for (int j = 0; j < graph.length; j++)
				my_graph[i][j] = 1000;
		for (int i = 0; i < graph.length; i++)
			for (int j = 0; j < graph[i].length; j++)
				my_graph[i][graph[i][j]] = 1;
		for (int k = 0; k < graph.length; k++) {
			for (int i = 0; i < graph.length; i++) {
				for (int j = 0; j < graph.length; j++) {
					if(i==j) continue;
					if(my_graph[i][j]>my_graph[i][k] + my_graph[k][j]) {
						my_graph[i][j] = Math.min(my_graph[i][j], my_graph[i][k] + my_graph[k][j]);
						list.get(i).get(j).add(k);
						list.get(j).get(i).add(k);
					}
				}
			}
		}
		for (int i = 0; i < graph.length; i++) {
			visit.add(i);
			dfs(i, 0);
			visit.remove(i);
		}
		return ans;
	}

	public static void dfs(int start, int dist) {
		if (visit.size() == my_graph.length) {
			if (dist < ans)
				ans = dist;
			return;
		}
		for (int i = 0; i < my_graph.length; i++) {
			if (visit.contains(i) || dist > ans)
				continue;
			else {
				HashSet<Integer> add=(HashSet<Integer>) list.get(start).get(i).clone();
				add.removeAll(visit);
				visit.addAll(list.get(start).get(i));
				visit.add(i);
				dfs(i, dist + my_graph[start][i]);
				visit.remove(i);
				visit.removeAll(add);
			}
		}
	}

	public static void main(String[] args) {
		int[][] graph = {{1,2,3,5},{0,5},{0,4},{0},{5,2},{0,4,1}};
		System.out.println(shortestPathLength(graph));
	}
}
