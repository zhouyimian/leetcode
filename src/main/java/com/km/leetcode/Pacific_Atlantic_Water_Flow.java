package com.km.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Pacific_Atlantic_Water_Flow {
	static List<int[]> ans=new ArrayList<>();
	static int[][] map;
	static int[][] dire= {{-1,0},{0,-1},{0,1},{1,0}};
	static int[][] matrix= {{1,2},{4,3}};
	static int[][] vis;
	public static List<int[]> pacificAtlantic(int[][] matrix) {
		if(matrix.length==0||matrix[0].length==0)
			return new ArrayList<int[]>();
		map=new int[matrix.length][matrix[0].length];
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				vis=new int[matrix.length][matrix[0].length];
				vis[i][j]=1;
				if(map[i][j]==1)
					add_neighbor(i,j);
				else if(judge_Pacific(i,j,matrix[i][j])&&jude_Atlantic(i,j,matrix[i][j])) {
					ans.add(new int[] {i,j});
					map[i][j]=1;
					add_neighbor(i,j);
				}
			}
		}
		return ans;
	}
	public static void add_neighbor(int line, int row) {
		for(int i=0;i<4;i++) {
			int x=line+dire[i][0];
			int y=row+dire[i][1];
			if(x<0||x>=matrix.length||y<0||y>=matrix[0].length)
				continue;
			if(matrix[x][y]<matrix[line][row]||map[x][y]==1)
				continue;
			else {
				map[x][y]=1;
				ans.add(new int[] {x,y});
			}
		}
	}
	
	public static boolean judge_Pacific(int line, int row, int value) {
		vis[line][row]=1;
		if(map[line][row]==1||line==0||row==0) {
			return true;
		}
		for(int i=0;i<4;i++) {
			int x=line+dire[i][0];
			int y=row+dire[i][1];
			if((x==0&&y<matrix[0].length&&y>=0&&matrix[x][y]<=value)||(y==0&&x<matrix.length&&x>=0&&matrix[x][y]<=value))
				return true;
			else if(x>=matrix.length||y>=matrix[0].length)
				continue;
			else if(matrix[x][y]<=value&&vis[x][y]==0&&judge_Pacific(x,y,matrix[x][y]))
				return true;
		}
		return false;
	}
	public static boolean jude_Atlantic(int line, int row, int value) {
		vis[line][row]=1;
		if(map[line][row]==1||line==matrix.length-1||row==matrix[0].length-1) {
			return true;
		}
		for(int i=0;i<4;i++) {
			int x=line+dire[i][0];
			int y=row+dire[i][1];
			if((x==matrix.length-1&&y<matrix[0].length&&y>=0&&matrix[x][y]<=value)||(y==matrix.length-1&&x<matrix.length&&x>=0&&matrix[x][y]<=value))
				return true;
			else if(x<0||y<0)
				continue;
			else if(matrix[x][y]<=value&&vis[x][y]==0&&jude_Atlantic(x,y,matrix[x][y]))
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		int[][] matrix= {{1,2},{4,3}};
		List<int[]> l=pacificAtlantic(matrix);
		for(int[] s:l) {
			System.out.println(s[0]+","+s[1]);
		}
	}
}
