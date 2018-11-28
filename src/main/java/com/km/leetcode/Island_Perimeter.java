package com.km.leetcode;

public class Island_Perimeter {
	static int max=0;
	static int[][] vis;
	static int[][] dire= {{0,-1},{0,1},{-1,0},{1,0}};
	public static int islandPerimeter(int[][] grid) {
		vis=new int[grid.length][grid[0].length];
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j]=check(grid,i,j);
			}
		}
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(grid[i][j]==0)
					continue;
				else {
					vis[i][j]=1;
					int temp=0;
					if(grid[i][j]==-1)
						temp=0;
					else
						temp=grid[i][j];
					for(int k=0;k<4;k++) {
						int x=dire[k][0]+i;
						int y=dire[k][1]+j;
						if(x>=grid.length||x<0||y>=grid[0].length||y<0||vis[x][y]==1||grid[x][y]==0)
							continue;
						else {
							temp=Square(grid,x,y,temp);
						}
					}
					if(temp>max)
						max=temp;
				}
			}
		}
		return max;
	}
	static int check(int[][] grid,int line,int row) {
		if(grid[line][row]==0)
			return 0;
		else {
			int num=0;
			for(int i=0;i<4;i++) {
				int x=dire[i][0]+line;
				int y=dire[i][1]+row;
				if(x>=grid.length||x<0||y>=grid[0].length||y<0||grid[x][y]==0)
					continue;
				else
					num++;
			}
			if(num==4)
				return -1;
			return 4-num;
		}
	}
	static int Square(int[][] grid,int line,int row,int temp) {
		vis[line][row]=1;
		if(grid[line][row]!=-1)
			temp+=grid[line][row];
		for(int i=0;i<4;i++) {
			int x=dire[i][0]+line;
			int y=dire[i][1]+row;
			if(x>=grid.length||x<0||y>=grid[0].length||y<0||vis[x][y]==1||grid[x][y]==0)
				continue;
			else
				temp=Square(grid,x,y,temp);
		}
		if(temp>max)
			max=temp;
		return temp;
	}
	public static void main(String[] args) {
		int[][] map= {{1,1},{1,0}};
		System.out.println(islandPerimeter(map));
	}
}
