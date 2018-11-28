package com.km.leetcode;

public class NQueens_II {
	static int ans=0;
	static int num;
	static int[][] map;
	public static int totalNQueens(int n) {
		map=new int[n][n];
		num=n;
		for(int i=0;i<n;i++) {
			map[0][i]=1;
			dfs(1);
			map[0][i]=0;
		}
		return ans;
	}
	static void dfs(int n) {
		if(n==num) {
			ans++;
			return;
		}
		for(int i=0;i<num;i++) {
			if(check(n,i)) {
				map[n][i]=1;
				dfs(n+1);
				map[n][i]=0;
			}
		}
	}
	static boolean check(int line,int row) {
		for(int i=0;i<line;i++) {
			if(map[i][row]==1)
				return false;
		}
		for(int i=line,j=row;i>=0&&j>=0;i--,j--) {
			if(map[i][j]==1)
				return false;
		}
		for(int i=line,j=row;i>=0&&j<num;i--,j++) {
			if(map[i][j]==1)
				return false;
		}
		return true;
		
	}
	public static void main(String[] args) {
		System.out.println(totalNQueens(8));
	}
}
