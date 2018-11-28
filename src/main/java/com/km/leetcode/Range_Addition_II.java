package com.km.leetcode;

public class Range_Addition_II {
	public int maxCount(int m, int n, int[][] ops) {
		int ans=0;
		if(ops.length==0)
			return m*n;
		int minline=Integer.MAX_VALUE;
		int minrow=Integer.MAX_VALUE;
		for(int i=0;i<ops.length;i++) {
			if(ops[i][0]<minline)
				minline=ops[i][0];
			if(ops[i][1]<minrow)
				minrow=ops[i][1];
		}
		return minline*minrow;
	}
}
