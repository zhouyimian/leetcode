package com.km.leetcode;

public class Minesweeper {
	static int[][] dire = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
	static int[][] vis;
	static char[][] ans;

	public static char[][] updateBoard(char[][] board, int[] click) {
		ans = new char[board.length][board[0].length];
		vis = new int[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				ans[i][j] = board[i][j];
			}
		}
		int click_x = click[0];
		int click_y = click[1];
		if (board[click_x][click_y] == 'M') {
			ans[click_x][click_y] = 'X';
		} else if (board[click_x][click_y] == 'E') {
			dfs(click_x, click_y);
		}
		return ans;
	}

	static void dfs(int line, int row) {
		if (line < 0 || row < 0 || line >= ans.length || row >= ans[0].length || vis[line][row] == 1) {
			return;
		}
		else {
			vis[line][row]=1;
			int temp = 0;
			for (int i = 0; i < 8; i++) {
				int x = line + dire[i][0];
				int y = row + dire[i][1];
				if (x < 0 || y < 0 || x >= ans.length || y >= ans[0].length)
					continue;
				else if (ans[x][y] == 'M')
					temp++;
			}
			if (temp != 0) {
				ans[line][row] = (char) ('0' + temp);
				return;
			} else {
				ans[line][row] = 'B';
				for (int i = 0; i < 8; i++) {
					int x = line + dire[i][0];
					int y = row + dire[i][1];
					dfs(x, y);
				}
			}
		}
	}
	public static void main(String[] args) {
		//char[][] g= {{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}};
		char[][] g= {{'E','E'},{'E','E'}};
		int[] click= {0,0};
		updateBoard(g,click);
	}
}
