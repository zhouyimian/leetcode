package com.km.leetcode;

public class Search_a_2D_Matrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length==0||matrix[0].length==0||matrix[0][0]>target||matrix[matrix.length-1][matrix[0].length-1]<target)
			return false;
		if(matrix.length==1)
			return binarySearch(matrix[0], target);
		for(int i=1;i<matrix.length;i++) {
			if(target==matrix[i-1][0])
				return true;
			else if(target>matrix[i-1][0]&&target<matrix[i][0]) {
				return binarySearch(matrix[i-1],target);
			}
		}
		return binarySearch(matrix[matrix.length-1],target);
	}
	boolean binarySearch(int[] nums,int num) {
		int low=0,high=nums.length-1;
		while(low<=high) {
			int mid=(low+high)/2;
			if(nums[mid]==num)
				return true;
			else if(nums[mid]>num) {
				high=mid-1;
			}
			else {
				low=mid+1;
			}
		}
		return false;
	}
}
