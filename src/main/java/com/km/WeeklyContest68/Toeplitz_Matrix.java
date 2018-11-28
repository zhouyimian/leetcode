package com.km.WeeklyContest68;

public class Toeplitz_Matrix {
	public boolean isToeplitzMatrix(int[][] matrix) {
		int i=1,j=1;
		int num=matrix[0][0];
		while(i<matrix.length&&j<matrix[i].length) {
			if(matrix[i][j]!=num)
				return false;
			i++;
			j++;
		}
		return true;
	}
}
