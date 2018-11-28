package com.km.leetcode;

public class Rectangle_Area {
	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int x1=Math.max(A,E);
		int x2=Math.max(Math.min(C, G), x1);
		int y1=Math.max(B, F);
		int y2=Math.max(Math.min(D, H), y1);
		return Math.abs(A-C)*Math.abs(B-D)+Math.abs(E-G)*Math.abs(F-H)-Math.abs(x1-x2)*Math.abs(y1-y2);
	}
	public static void main(String[] args) {
		System.out.println(computeArea(-2,-2,2,2,3,3,4,4));
	}
}
