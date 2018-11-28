package com.km.leetcode;

public class Trapping_Rain_Water {
	public int trap(int[] height) {
		int[] left=new int[height.length];
		int[] right=new int[height.length];
		int[] sum=new int[height.length];
		sum[0]=height[0];
		for(int i=1;i<height.length;i++)
			sum[i]=sum[i-1]+height[i];
		for(int i=1;i<height.length;i++) {
			int j=i-1;
			while(j>=0&&height[j])
		}
		return 0;
	}
}
