package com.km.leetcode;

import java.util.*;

public class Image_Smoother {
	int line;
	int row;
	int dire[][]= {{-1,-1},{-1,0},{-1,1},{0,-1},{0,0},{0,1},{1,-1},{1,0},{1,1}};
	public int[][] imageSmoother(int[][] M) {
		line=M.length;
		if(M.length==0)
			return new int[0][];
		row=M[0].length;
		int[][] ans=new int[M.length][];
		for(int i=0;i<line;i++) {
			ans[i]=new int[M[i].length];
		}
		for(int i=0;i<line;i++) {
			for(int j=0;j<row;j++) {
				ans[i][j]=check(i,j,M);
			}
		}
		return ans;
	}
	int check(int x,int y,int[][] m) {
		int sum=0;
		int l,r;
		int count=0;
		for(int i=0;i<dire.length;i++) {
			l=x+dire[i][0];
			r=y+dire[i][1];
			if(l>=0&&l<line&&r>=0&&r<row) {
				sum+=m[l][r];
				count++;
			}
		}
		Map<Integer,Integer> map=new HashMap<>();
		return sum/count;
	}
}
