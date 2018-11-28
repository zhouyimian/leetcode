package com.km.leetcode;

public class Valid_Sudoku {
	public static boolean isValidSudoku(char[][] board) {
		if(board.length==0||board[0].length==0)
			return true;
		boolean flag = true;
		for (int i = 0; i < board.length; i++) {
			flag = checkline(i, board);
			if (!flag)
				return false;
		}
		for (int i = 0; i < board[0].length; i++) {
			flag = checkrow(i, board);
			if (!flag)
				return false;
		}
		for (int i = 0; i < board.length; i += 3) {
			for (int j = 0; j < board[0].length; j += 3) {
				flag = checkblock(i, j, board);
				if (!flag)
					return false;
			}
		}
		return true;
	}

	static boolean checkline(int line, char[][] board) {
		int[] num= {1,1,1,1,1,1,1,1,1,1};
		for(int i=0;i<9;i++) {
			if(board[line][i]>='0'&&board[line][i]<='9') {
				num[board[line][i]-'0']--;
				if(num[board[line][i]-'0']<0)
					return false;
			}
		}
		return true;
	}

	static boolean checkrow(int row, char[][] board) {
		int[] num= {1,1,1,1,1,1,1,1,1,1};
		for(int i=0;i<9;i++) {
			if(board[i][row]>='0'&&board[i][row]<='9') {
				num[board[i][row]-'0']--;
				if(num[board[i][row]-'0']<0)
					return false;
			}
		}
		return true;
	}

	static boolean checkblock(int line, int row, char[][] board) {
		int[] num= {1,1,1,1,1,1,1,1,1,1};
		for(int i=line;i<line+3;i++) {
			for(int j=row;j<row+3;j++) {
				if(board[i][j]>='0'&&board[i][j]<='9') {
					num[board[i][j]-'0']--;
					if(num[board[i][j]-'0']<0)
						return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		char[][] s= {{'.','8','7','6','5','4','3','2','1'},
				{'2','.','.','.','.','.','.','.','.','.'},
				{'3','.','.','.','.','.','.','.','.','.',},
				{'4','.','.','.','.','.','.','.','.','.',},
				{'5','.','.','.','.','.','.','.','.','.',},
				{'6','.','.','.','.','.','.','.','.','.',},
				{'7','.','.','.','.','.','.','.','.','.',},
				{'8','.','.','.','.','.','.','.','.','.',},
				{'9','.','.','.','.','.','.','.','.','.',}};
		System.out.println(isValidSudoku(s));
	}
}
