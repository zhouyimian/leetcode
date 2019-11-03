package com.km.leetcode;

import java.util.Arrays;

public class Sudoku_Solver {
	public static void solveSudoku(char[][] board) {
		if(board.length==0||board[0].length==0)
			return;
		dfs(board);
	}
	static boolean dfs(char[][] board) {
		for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                	for(char c='1';c<='9';c++) {
                		if(checkline(i,c,board)&&checkrow(j,c,board)&&checkblock(i,j,c,board)) {
                			board[i][j]=c;
                			if(dfs(board)) 
                				return true;
                			else
                				board[i][j]='.';
                		}
                	}
                	return false;
                }
            }
		}
		return true;
	}
	static boolean fill(char[][] m) {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(m[i][j]=='.')
					return false;
			}
		}
		return true;
	}
	static boolean checkline(int line,char c,char[][] board) {
		for (int i = 0; i < 9; i++) {
			if (board[line][i] == c) {
				return false;
			}
		}
		return true;
	}

	static boolean checkrow(int row, char c, char[][] board) {
		for (int i = 0; i < 9; i++) {
			if (board[i][row] == c) {
				return false;
			}
		}
		return true;
	}

	static boolean checkblock(int line, int row, char c, char[][] board) {
		line = line - line % 3;
		row = row - row % 3;
		for (int i = line; i < line + 3; i++) {
			for (int j = row; j < row + 3; j++) {
				if (board[i][j] == c) {
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		char[][] s= {{'.','.','.','5','2','.','.','.','6'},
				{'.','.','6','.','.','9','.','.','1'},
				{'.','7','2','.','3','.','4','8','.'},
				{'.','.','3','.','.','.','1','.','.'},
				{'.','.','.','1','.','6','.','.','.'},
				{'.','.','9','.','.','.','7','.','.'},
				{'.','1','4','.','7','.','6','5','.'},
				{'9','.','.','2','.','.','8','.','.'},
				{'3','.','.','.','1','5','.','.','.'}};
		solveSudoku(s);
        System.out.println(Arrays.deepToString(s));
	}
}

/*
 * class Solution {
    char[][] map;
	boolean ans=false;
	public void solveSudoku(char[][] board) {
		map=board;
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(board[i][j]>='0'&&board[i][j]<='9')
					continue;
				else {
					dfs(i,j);
					if(ans==true)
						return;
				}
			}
		}
	}
	void dfs(int line,int row) {
		if(ans==true)
			return;
		for(int i=1;i<=9;i++) {
			map[line][row]=(char) (i+'0');
			if(checkline(line)&&checkrow(row)&&checkblock(line,row)) {
				for(int j=line;j<9;j++) {
					for(int k=0;k<9;k++) {
						if(map[j][k]>='0'&&map[j][k]<='9')
							continue;
						else
							dfs(j,k);
					}
				}
				ans=true;
			}
		}
	}
	boolean checkline(int line) {
		int[] num= {1,1,1,1,1,1,1,1,1,1};
		for(int i=0;i<9;i++) {
			if(map[line][i]>='0'&&map[line][i]<='9') {
				num[map[line][i]-'0']--;
				if(num[map[line][i]-'0']<0)
					return false;
			}
		}
		return true;
	}

	boolean checkrow(int row) {
		int[] num= {1,1,1,1,1,1,1,1,1,1};
		for(int i=0;i<9;i++) {
			if(map[i][row]>='0'&&map[i][row]<='9') {
				num[map[i][row]-'0']--;
				if(num[map[i][row]-'0']<0)
					return false;
			}
		}
		return true;
	}
	boolean checkblock(int line, int row) {
		int[] num= {1,1,1,1,1,1,1,1,1,1};
		line=line-line%3;
		row=row-row%3;
		for(int i=line;i<line+3;i++) {
			for(int j=row;j<row+3;j++) {
				if(map[i][j]>='0'&&map[i][j]<='9') {
					num[map[i][j]-'0']--;
					if(num[map[i][j]-'0']<0)
						return false;
				}
			}
		}
		return true;
	}
}


 * */
