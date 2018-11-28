package com.km.leetcode;

public class Construct_the_Rectangle {
	public int[] constructRectangle(int area) {
		int length, width;
		width = (int) Math.sqrt((double) area);
		if (area % width == 0) {
			length = width;
		} else {
			while (area % width != 0) {
				width--;
			}
			length = area / width;
		}
		int[] ans = new int[2];
		ans[0] = width;
		ans[1] = length;
		return ans;
	}
}
