package com.km.leetcode;

public class Unique_Paths_II {
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid.length==0||obstacleGrid[0].length==0||obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1)
			return 0;
		int[][] dp=new int[obstacleGrid.length][obstacleGrid[0].length];
		int i=0;
		while(i<obstacleGrid.length&&obstacleGrid[i][0]!=1)
			dp[i++][0]=1;
		i=0;
		while(i<obstacleGrid[0].length&&obstacleGrid[0][i]!=1)
			dp[0][i++]=1;
		for(i=1;i<obstacleGrid.length;i++) {
			for(int j=1;j<obstacleGrid[i].length;j++) {
				if(obstacleGrid[i][j]==1)
					continue;
				else
					dp[i][j]=dp[i-1][j]+dp[i][j-1];
			}
		}
		return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
	}
	public static void main(String[] args) {
		int[][] s= {{0,0},{1,1},{0,0}};
		System.out.println(uniquePathsWithObstacles(s));
		
	}
}
