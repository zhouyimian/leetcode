package com.km.leetcode;

public class Spiral_Matrix_II {
	public static int[][] generateMatrix(int n) {
		if (n == 0)
			return new int[0][0];
		if (n == 1) {
			int[][] ans = new int[1][1];
			ans[0][0] = 1;
			return ans;
		} else {
			int[][] ans = new int[n][n];
			int direction = 4;
			int count = 1;
			int line = 0, row = 0;
			while (count <= n * n) {
				if (direction == 1) {
					while (line>=0&&ans[line][row] == 0) {
						ans[line--][row] = count++;
					}
					line++;
					row++;
					direction=4;
				} else if (direction == 2) {
					while (line<n&&ans[line][row] == 0) {
						ans[line++][row] = count++;
					}
					line--;
					row--;
					direction=3;
				} else if (direction == 3) {
					while (row>=0&&ans[line][row] == 0) {
						ans[line][row--] = count++;
					}
					line--;
					row++;
					direction=1;
				} else {
					while (row<n&&ans[line][row] == 0) {
						ans[line][row++] = count++;
					}
					line++;
					row--;
					direction=2;
				}
			}
			return ans;
		}
	}
	public static void main(String[] args) {
		int[][] a=new int[3][3];
		a=generateMatrix(3);
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(a[i][j]);
			}
			System.out.println("");
		}
	}
}
