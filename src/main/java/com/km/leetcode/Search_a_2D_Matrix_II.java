package com.km.leetcode;

public class Search_a_2D_Matrix_II {
	public static boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length==0||matrix[0].length==0||matrix[0][0]>target||matrix[matrix.length-1][matrix[0].length-1]<target)
			return false;
		int row=0;
		int col=matrix[0].length-1;
		while(row<matrix.length&&col>=0) {
			if(matrix[row][col]==target)
				return true;
			else if(matrix[row][col]>target)
				col--;
			else
				row++;
		}
		return false;
	}
	public static void main(String[] args) {
		int[][]nums= {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		searchMatrix(nums,20);
	}
}
