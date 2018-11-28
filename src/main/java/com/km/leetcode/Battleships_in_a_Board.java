package com.km.leetcode;

public class Battleships_in_a_Board {
	static int[][] dire= {{-1,0},{1,0},{0,-1},{0,1}};
	static int[][] vis;
	public static int countBattleships(char[][] board) {
		int ans=0;
		vis=new int[board.length][board[0].length];
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				if(vis[i][j]==0&&board[i][j]!='.') {
					ans++;
					dfs(i,j,board);
				}
			}
		}
		return ans;
	}
	static void dfs(int line,int row,char[][] board) {
		if(line<0||line>=vis.length||row<0||row>=vis[0].length)
			return;
		if(board[line][row]=='.'||vis[line][row]==1)
			return;
		vis[line][row]=1;
		for(int i=0;i<4;i++) {
			int x=line+dire[i][0];
			int y=row+dire[i][1];
			dfs(x,y,board);
		}
	}
	public static void main(String[] args) {
		char[][] board= {{'X','.','.','X'},{'.','.','.','X'},{'.','.',',','X'}};
		System.out.println(countBattleships(board));
	}
}
