package com.km.leetcode;
public class Max_Area_of_Island {    
    int num,max;       
    int[][] dirt = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };     
    public int maxAreaOfIsland(int[][] grid) {
        int[][] vis=new int[grid.length][grid[0].length];
        for (int i = 0; i <grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] != 0&&vis[i][j]==0) {
					dfs(i, j,grid,vis);
					if (num > max)
						max = num;
					num = 0;
				}
			}
		}
        return max;
	}
    void dfs(int line, int row,int[][] grid,int[][] vis) {
		if (line < 0 || line >= grid.length || row < 0 || row >= grid[line].length) {
			return;
		} else if (grid[line][row] == 0||vis[line][row]==1)
			return;
		else {
			vis[line][row]=1;
			num++;
			for (int i = 0; i < 4; i++) {
				int x = line + dirt[i][0];
				int y = row + dirt[i][1];
				dfs(x,y,grid,vis);
			}
		}
	}
}
