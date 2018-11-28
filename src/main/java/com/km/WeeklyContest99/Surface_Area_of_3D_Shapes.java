package com.km.WeeklyContest99;

public class Surface_Area_of_3D_Shapes {
	public int surfaceArea(int[][] grid) {
		int[] line_max = new int[grid.length];
		int[] row_max = new int[grid[0].length];
		int ans = 0;
		int count=0;
		for(int i=0;i<grid.length;i++) {
			int maxline=0;
			for(int j=0;j<grid[i].length;j++) {
				if(grid[i][j]>maxline)
					maxline=grid[i][j];
				if(grid[i][j]!=0)
					count++;
			}
			line_max[i]=maxline;
		}
		for(int i=0;i<grid.length;i++) {
			int maxrow=0;
			for(int j=0;j<grid.length;j++) {
				if(grid[j][i]>maxrow)
					maxrow=grid[j][i];
			}
			row_max[i]=maxrow;
		}
		ans+=2*count;
		for(int i=0;i<grid.length;i++) {
			ans+=2*line_max[i];
			ans+=2*row_max[i];
		}
		return ans;
	}

	public static void main(String[] args) {

	}

}
