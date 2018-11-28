package com.km.leetcode;

import java.util.*;

public class Kth_Smallest_Element_in_a_Sorted_Matrix {
	public static int kthSmallest(int[][] matrix, int k) {
		List<Integer> list=new ArrayList<>();
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				list.add(matrix[i][j]);
			}
		}
		Collections.sort(list);
		return list.get(k-1);
	}
	public static void main(String[] args) {
		Stack<Integer> stack=new Stack<>();
		stack.pop();
		int[][] n= {{1,5,9},{10,11,13},{12,13,15}};
		System.out.println(kthSmallest(n,8));
	}
}
