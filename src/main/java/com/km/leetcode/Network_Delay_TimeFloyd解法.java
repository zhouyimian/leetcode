package com.km.leetcode;

public class Network_Delay_TimeFloyd解法 {
	public static int networkDelayTime(int[][] times, int N, int K) {
		int[] vis = new int[N + 1];
		int[] dist = new int[N + 1];
		int[][] graph = new int[N + 1][N + 1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(i==j)
					continue;
				else
					graph[i][j]=-1;
			}
		}
		for (int i = 0; i < times.length; i++) {
			int from = times[i][0];
			int to = times[i][1];
			int value = times[i][2];
			graph[from][to] = value;
		}
		
		int ans;
		for (int m = 1; m <= N; m++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(i==j)
						continue;
					if(graph[i][j]==-1&&graph[i][m]!=-1&&graph[m][j]!=-1) {
						graph[i][j]=graph[i][m]+graph[m][j];
					}
					else if(graph[i][j]>graph[i][m]+graph[m][j]&&graph[i][m]!=-1&&graph[m][j]!=-1) {
						graph[i][j]=graph[i][m]+graph[m][j];
					}
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			if (graph[K][i] == -1) {
				return -1;
			} else {
				max = Math.max(max, graph[K][i]);
			}

		}
		return max;
	}
	public static void main(String[] arges) {
		/*int[][] times = { {3,5,78},{2,1,1},{1,3,0},{4,3,59},{5,3,85},{5,2,22},{2,4,23},
				{1,4,43},{4,5,75},{5,1,15},{1,5,91},{4,1,16},{3,2,98},{3,4,22},{5,4,31},
				{1,2,0},{2,5,4},{4,2,51},{3,1,36},{2,3,59} };*/
		int[][] times= {{1,2,1},{2,3,2},{1,3,1}};
		int N = 3;
		int K = 2;
		System.out.println(networkDelayTime(times, N, K));
	}
}
