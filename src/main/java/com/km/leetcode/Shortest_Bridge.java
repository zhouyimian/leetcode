package com.km.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Bridge {
	int[][] dire = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

	public int shortestBridge(int[][] A) {
		Queue<int[]> qa= new LinkedList<>();
        Queue<int[]> qb= new LinkedList<>();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				if (A[i][j] == 1) {
					if (qa.isEmpty())
						dfs(qa, i, j, A);
					else
						dfs(qb, i, j, A);
				}
			}
		}
		int ans=0;
		while(!qa.isEmpty()&&!qb.isEmpty()) {
			for(int i=qa.size();i>0;i--) {
				int[] cur=qa.poll();
				for(int j=0;j<4;j++) {
					int x=cur[0]+dire[j][0];
					int y=cur[1]+dire[j][1];
					if(x<0||y<0||x>=A.length||y>=A[0].length||A[x][y]==3) continue;
					if(A[x][y]==4)
						return ans;
					A[x][y]=3;
					qa.add(new int[] {x,y});
				}
			}
			for(int i=qb.size();i>0;i--) {
				int[] cur=qb.poll();
				for(int j=0;j<4;j++) {
					int x=cur[0]+dire[j][0];
					int y=cur[1]+dire[j][1];
					if(x<0||y<0||x>=A.length||y>=A[0].length||A[x][y]==4) continue;
					if(A[x][y]==3)
						return ans+1;
					A[x][y]=4;
					qb.add(new int[] {x,y});
				}
			}
			ans+=2;
		}
		return 1;
	}
	
	public void dfs(Queue<int[]> qa, int m, int n, int[][] A) {
		if (m < 0 || n < 0 || m >= A.length || n >= A[0].length || A[m][n] != 1)
			return;
		A[m][n] = 2;
		qa.add(new int[] {m,n});
		for (int i = 0; i < 4; i++) {
			int x = dire[i][0] + m;
			int y = dire[i][1] + n;
			dfs(qa, x, y, A);
		}
	}
	public static void main(String[] args) {
		int[][] nums= {{0,1,0},{0,0,0},{0,0,1}};
		Shortest_Bridge test=new Shortest_Bridge();
		System.out.println(test.shortestBridge(nums));
	}
}
