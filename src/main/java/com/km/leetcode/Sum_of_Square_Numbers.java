package com.km.leetcode;

public class Sum_of_Square_Numbers {
	public boolean judgeSquareSum(int c) {
		for (int i = 0; i <= c; i++) {
			int num = c - i * i;
			if(num<0)
				break;
			double sq=Math.sqrt(num);
			if(sq==(int)sq)
				return true;
		}
		return false;
	}
}
