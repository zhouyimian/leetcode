package com.km.leetcode;

import java.util.*;

public class Number_of_Boomerangs {
	public int numberOfBoomerangs(int[][] points) {
		int ans=0;
		Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<points.length;i++) {
			for(int j=0;j<points.length;j++) {
				int d=distanct(points[i],points[j]);
				map.put(d, map.getOrDefault(d, 0)+1);
			}
			for(int val:map.values())
				ans+=val*(val-1);
			map.clear();
		}
		return ans;
	}
	int distanct(int[] a,int []b) {
		int x=a[0]-b[0];
		int y=a[1]-b[1];
		return x*x+y*y;
	}
}
