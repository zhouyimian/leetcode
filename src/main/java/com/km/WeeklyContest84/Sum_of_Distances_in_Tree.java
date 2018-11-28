package com.km.WeeklyContest84;

public class Sum_of_Distances_in_Tree {
	public static int[] sumOfDistancesInTree(int N, int[][] edges) {
		int[] ans=new int[N];
		int[][] value=new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				value[i][j]=99999;
			}
		}
		for(int i=0;i<edges.length;i++) {
			value[edges[i][0]][edges[i][1]]=1;
			value[edges[i][1]][edges[i][0]]=1;
		}
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(value[i][j]>(value[i][k]+value[k][j]))
						value[i][j]=value[i][k]+value[k][j];
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i==j)
					continue;
				else
					ans[i]+=value[i][j];
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int N=6;
		int[][] A = {{0,1},{0,2},{2,3},{2,4},{2,5}};
		sumOfDistancesInTree(N,A);
	}
}
