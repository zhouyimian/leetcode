package com.km.leetcode;

public class Flood_Fill {
	static int[][] dire= {{-1,0},{1,0},{0,-1},{0,1}};
	static int[][] vis;
	static int length;
	static int width;
	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int oldColor=image[sr][sc];
		length=image.length;
		width=image[0].length;
		vis=new int[length][width];
		vis[sr][sc]=1;
		image[sr][sc]=newColor;
		for(int i=0;i<4;i++) {
			int x=dire[i][0]+sr;
			int y=dire[i][1]+sc;
			dfs(x,y,oldColor,newColor,image);
		}
		return image;
	}
	static void dfs(int line,int row,int oldColor,int newColor,int[][] image) {
		if(line<0||row<0||line>=length||row>=width||vis[line][row]==1||image[line][row]!=oldColor)
			return;
		vis[line][row]=1;
		image[line][row]=newColor;
		for(int i=0;i<4;i++) {
			int x=dire[i][0]+line;
			int y=dire[i][1]+row;
			dfs(x,y,oldColor,newColor,image);
		}
	}
	public static void main(String[] args) {
		int[][] g= {{1,1,1},{1,1,0},{1,0,1}};
		floodFill(g,1,1,2);
	}
}
