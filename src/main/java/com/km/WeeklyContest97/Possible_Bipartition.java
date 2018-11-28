package com.km.WeeklyContest97;

import java.util.ArrayList;
import java.util.List;

public class Possible_Bipartition {
	static List<ArrayList<Integer>> map = new ArrayList<>();
	static int[] vis;
	static int count = 0;
	static int tar;

	public static boolean possibleBipartition(int N, int[][] dislikes) {
		vis = new int[N + 1];
		tar = N;
		for (int i = 0; i <= N; i++)
			map.add(new ArrayList<>());
		for (int i = 0; i < dislikes.length; i++) {
			int from = dislikes[i][0];
			int to = dislikes[i][1];
			map.get(from).add(to);
			map.get(to).add(from);
		}
		for (int i = 1; i <= N; i++) {
			if (count == N)
				return true;
			if (vis[i] == 0) {
				vis[i] = 1;
				count++;
				List<Integer> list = map.get(i);
				for (int j = 0; j < list.size(); j++) {
					if (vis[list.get(j)] == 1)
						return false;
					else if (vis[list.get(j)] == 0) {
						count++;
						vis[list.get(j)] = 2;
						if (dfs(list.get(j)) == false)
							return false;
					}
				}
			}
		}
		return true;
	}

	public static boolean dfs(int point) {
		if (count == tar)
			return true;
		List<Integer> list = map.get(point);
		for (int i = 0; i < list.size(); i++) {
			if (vis[point] == 1) {
				if (vis[list.get(i)] == 1)
					return false;
				else if (vis[list.get(i)] == 0) {
					count++;
					vis[list.get(i)] = 2;
					if (dfs(list.get(i)) == false)
						return false;
				}
			} else {
				if (vis[list.get(i)] == 2)
					return false;
				else if (vis[list.get(i)] == 0) {
					count++;
					vis[list.get(i)] = 1;
					if (dfs(list.get(i)) == false)
						return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] dislikes = { { 1, 2 } };
		System.out.println(possibleBipartition(3, dislikes));
	}

}
