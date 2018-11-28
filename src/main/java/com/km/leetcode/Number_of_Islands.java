package com.km.leetcode;

public class Number_of_Islands {
	int[][] dir= {{0,-1},{0,1},{-1,0},{1,0}};
	int[][] vis;
	public int numIslands(char[][] grid) {
		int ans=0;
		if(grid==null||grid.length==0||grid[0].length==0)
			return 0;
		vis=new int[grid.length][grid[0].length];
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(grid[i][j]=='1'&&vis[i][j]==0) {
					ans++;
					dfs(i,j,grid);
				}
			}
		}
		return ans;
	}
	public void dfs(int line, int col,char[][] grid) {
		for(int i=0;i<4;i++) {
			int x=line+dir[i][0];
			int y=col+dir[i][1];
			if(x<0||y<0||x>=grid.length||y>=grid[0].length)
				continue;
			if(vis[x][y]==0&&grid[x][y]=='1') {
				vis[x][y]=1;
				dfs(x,y,grid);
			}
		}
	}
}
