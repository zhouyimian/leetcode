package com.km.WeeklyContest77;

public class Max_Increase_to_Keep_City_Skyline {
	public int maxIncreaseKeepingSkyline(int[][] grid) {
		int ans=0;
		for(int i=0;i<grid.length;i++) {
			int maxline=0;
			for(int k=0;k<grid[i].length;k++) {
				if(grid[i][k]>maxline)
					maxline=grid[i][k];
			}
			for(int j=0;j<grid[i].length;j++) {
				int maxrow=0;
				for(int k=0;k<grid.length;k++) {
					if(grid[k][j]>maxrow)
						maxrow=grid[k][j];
				}
				if(grid[i][j]==maxline||grid[i][j]==maxrow)
					continue;
				else
					ans+=(maxline>maxrow?(maxrow-grid[i][j]):(maxline-grid[i][j]));
			}
		}
		return ans;
	}
}
