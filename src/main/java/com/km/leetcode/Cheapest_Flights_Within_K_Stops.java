package com.km.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Cheapest_Flights_Within_K_Stops {
	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		int step=0;
		int ans=Integer.MAX_VALUE;
		int[][] map=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==j)
					continue;
				map[i][j]=Integer.MAX_VALUE;
			}
		}
		for(int i=0;i<flights.length;i++) {
			map[flights[i][0]][flights[i][1]]=flights[i][2];
		}
		List<Integer> cost=new ArrayList<>();
		List<Integer> next=new ArrayList<>();
		for(int i=0;i<n;i++) {
			if(src==i||map[src][i]==Integer.MAX_VALUE)
				continue;
			else {
				cost.add(map[src][i]);
				next.add(i);
			}
		}
		if(map[src][dst]!=Integer.MAX_VALUE)
			ans=map[src][dst];
		while(step<K&&next!=null) {
			List<Integer> cost2=new ArrayList<>();
			List<Integer> next2=new ArrayList<>();
			for(int i=0;i<next.size();i++) {
				int d=next.get(i);
				for(int j=0;j<n;j++) {
					if(j==d||map[d][j]==Integer.MAX_VALUE||(ans!=Integer.MAX_VALUE&&cost.get(i)+map[d][j]>=ans))
						continue;
					if(j==dst&&cost.get(i)+map[d][j]<=ans)
						ans=cost.get(i)+map[d][j];
					next2.add(j);
					cost2.add(cost.get(i)+map[d][j]);
				}
			}
			cost.clear();
			next.clear();
			cost.addAll(cost2);
			next.addAll(next2);
			cost2.clear();
			next2.clear();
			step++;
		}
		return ans==Integer.MAX_VALUE?-1:ans;
	}
	public static void main(String[] args) {
		int[][] s= {{4,1,1},{1,2,3},{0,3,2},{0,4,10},{3,1,1},{1,4,3}};
		System.out.println(findCheapestPrice(5,s,2,1,1));
	}
}
