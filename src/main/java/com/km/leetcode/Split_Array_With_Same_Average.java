package com.km.leetcode;

import java.util.Arrays;

public class Split_Array_With_Same_Average {
	static int[] number;
	static int vis[];
	static int count = 0;
	static double ave;
	static boolean ans = false;

	public static boolean splitArraySameAverage(int[] A) {
		if (A.length == 1)
			return false;
		number = A;
		vis = new int[A.length];
		Arrays.sort(A);
		double sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}
		ave = sum / A.length;
		search(0, 0, 0);
		return ans;
	}

	static void search(int num, double sum, int index) {
		if (ans == true || sum / num > ave)
			return;
		if (sum / num == ave) {
			double s = 0;
			for (int i = 0; i < number.length; i++) {
				if (vis[i] == 0)
					s += number[i];
			}
			if(number.length-num==0)
				return;
			if (s / (number.length - num) == ave) {
				ans = true;
				return;
			}
		}
		for (int i = index; i < number.length; i++) {
			if ((sum + number[i]) / (num + 1) <= ave) {
				vis[i] = 1;
				search(num + 1, sum + number[i], i + 1);
				
				vis[i] = 0;
			} else
				return;
		}
	}

	public static void main(String[] args) {
		int[] nums = {33,86,88,78,21,76,19,20,88,76,10,25,37,97,58,89,65,59,98,57,50,30,58,5,61,72,23,6};
		System.out.println(splitArraySameAverage(nums));
	}
}
