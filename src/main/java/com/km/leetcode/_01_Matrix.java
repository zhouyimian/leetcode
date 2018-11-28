package com.km.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _01_Matrix {
	public static int[][] updateMatrix(int[][] matrix) {
		int[][] temp;
		List<int[]> list=new ArrayList<>();
		if(matrix.length==0||matrix[0].length==0)
			return matrix;
		temp=new int[matrix.length][matrix[0].length];
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				if(matrix[i][j]==0) {
					temp[i][j]=0;
					int[] t= {i,j};
					list.add(t);
				}
				else {
					temp[i][j]=Integer.MAX_VALUE;
				}
			}
		}
		List<int[]> list2=new ArrayList<>();
		int[][] dire= {{-1,0},{0,-1},{0,1},{1,0}};
		while (list.size() != 0) {
			for (int i = 0; i < list.size(); i++) {
				int[] fx=list.get(i);
				for(int j=0;j<4;j++) {
					int x=fx[0]+dire[j][0];
					int y=fx[1]+dire[j][1];
					if(x<0||x>=temp.length||y<0||y>=temp[0].length)
						continue;
					else if(temp[x][y]!=Integer.MAX_VALUE&&temp[fx[0]][fx[1]]+1>=temp[x][y])
						continue;
					else {
						temp[x][y]=temp[fx[0]][fx[1]]+1;
						int[] e= {x,y};
						list2.add(e);
					}
				}
			}
			list.clear();
			list.addAll(list2);
			list2.clear();
		}
		return temp;
	}
	public static void main(String[] args) {
		int[][] s= {{0,0,0},{0,1,0},{1,1,1}};
		s=updateMatrix(s);
		for(int i=0;i<s.length;i++) {
			for(int j=0;j<s[i].length;j++) {
				System.out.print(s[i][j]+" ");
			}
			System.out.println();
		}
	}
}
