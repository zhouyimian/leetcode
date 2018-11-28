package com.km.leetcode;

public class Network_Delay_TimeDijkastra解法 {
	public static int networkDelayTime(int[][] times, int N, int K) {
		int[] dist=new int[N+1];
		int[][] graph=new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(i==j)
					continue;
				else {
					graph[i][j]=Integer.MAX_VALUE;
				}
			}
		}
		for(int i=0;i<times.length;i++) {
			int from=times[i][0];
			int to=times[i][1];
			int value=times[i][2];
			graph[from][to]=value;
		}
		for(int i=1;i<=N;i++) {
			dist[i]=graph[K][i];
		}
		int[] vis=new int[N+1];
		vis[K]=1;
		for(int i=1;i<N;i++) {
			int minindex = i;
			int min=Integer.MAX_VALUE;
			for(int j=1;j<=N;j++) {
				if(dist[j]!=Integer.MAX_VALUE&&dist[j]<min&&vis[j]==0) {
					minindex=j;
					min=dist[j];
				}
			}
			vis[minindex]=1;
			dist[minindex]=min;
			for(int j=1;j<=N;j++) {
				if(dist[j]>dist[minindex]+graph[minindex][j]&&vis[j]==0&&graph[minindex][j]!=Integer.MAX_VALUE) {
					dist[j]=dist[minindex]+graph[minindex][j];
				}
			}
		}
		int max=0;
		for(int i=1;i<=N;i++) {
			if(dist[i]==Integer.MAX_VALUE)
				return -1;
			else
				max=Math.max(max, dist[i]);
		}
		return max;
	}
	public static void main(String[] args) {
		int[][] times= {{2,1,1},{2,3,1},{3,4,1}};
		int N=4;
		int K=2;
		System.out.println(networkDelayTime(times,N,K));
	}
}
