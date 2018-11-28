package com.km.leetcode;

import java.util.*;

public class Reconstruct_Itinerary {
	public static List<String> findItinerary(String[][] tickets) {
		int count=0;
		Map<String,Integer> map=new HashMap<>();
		map.put("JFK", 0);
		for(int i=0;i<tickets.length;i++) {
			if(!map.containsKey(tickets[i][0]))
				map.put(tickets[i][0], ++count);
			if(!map.containsKey(tickets[i][1]))
				map.put(tickets[i][1], ++count);
		}
		String[] name=new String[count+1];
		int[][] graph=new int[count+1][count+1];
		for(int i=0;i<tickets.length;i++) {
			int from=map.get(tickets[i][0]);
			name[from]=tickets[i][0];
			int to=map.get(tickets[i][1]);
			name[to]=tickets[i][1];
			graph[from][to]=1;
		}
		int start=0;
		List<String> ans=new ArrayList<>();
		while(true) {
			String s=null;
			for(int j=0;j<=count;j++) {
				if(s==null&&graph[start][j]==1)
					s=name[j];
				else if(graph[start][j]==1&&name[j].compareTo(s)<0)
					s=name[j];
			}
			if(s==null) {
				ans.add(name[start]);
				break;
			}
			ans.add(name[start]);
			int end=map.get(s);
			graph[start][end]=0;
			start=end;
		}
		return ans;
	}
	public static void main(String[] args) {
		String[][] s= {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
		for(String temp:findItinerary(s)) {
			System.out.println(temp);
		}
	}
}
