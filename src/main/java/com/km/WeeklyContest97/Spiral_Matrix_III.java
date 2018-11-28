package com.km.WeeklyContest97;

public class Spiral_Matrix_III {
	public static int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
		int[][] ans = new int[R * C][2];
		ans[0][0] = r0;
		ans[0][1] = c0;
		int count = 1;
		int now_line = r0;
		int now_row = c0;
		for (int i = 1; count != R * C; i++) {
			if (i % 2 == 1) {
				for (int j = 1; j <= i; j++) {
					if(count==R*C)
						break;
					now_row += 1;
					if (now_line < R && now_row < C && now_line >= 0 && now_row >= 0) {
						ans[count][0] = now_line;
						ans[count][1] = now_row;
						count++;
					}
				}
				for (int j = 1; j <= i; j++) {
					if(count==R*C)
						break;
					now_line += 1;
					if (now_line < R && now_row < C && now_line >= 0 && now_row >= 0) {
						ans[count][0] = now_line;
						ans[count][1] = now_row;
						count++;
					}
				}
			} else {
				for (int j = 1; j <= i; j++) {
					if(count==R*C)
						break;
					now_row -= 1;
					if (now_line < R && now_row < C && now_line >= 0 && now_row >= 0) {
						ans[count][0] = now_line;
						ans[count][1] = now_row;
						count++;
					}
				}
				for (int j = 1; j <= i; j++) {
					if(count==R*C)
						break;
					now_line -= 1;
					if (now_line < R && now_row < C && now_line >= 0 && now_row >= 0) {
						ans[count][0] = now_line;
						ans[count][1] = now_row;
						count++;
					}
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		spiralMatrixIII(1, 4, 0, 0);
	}
}
