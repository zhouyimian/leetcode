package com.km.WeeklyContest112;

import java.util.HashMap;
import java.util.Map;

public class Most_Stones_Removed_with_Same_Row_or_Column {
	int count;

	public int removeStones(int[][] stones) {
		count = stones.length;
		Map<String, String> parent = new HashMap<>();
		for (int i = 0; i < stones.length; i++) {
			String s = stones[i][0] + " " + stones[i][1];
			parent.put(s, s);
		}
		for (int i = 0; i < stones.length; i++) {
			String s1 = stones[i][0] + " " + stones[i][1];
			for (int j = 0; j < stones.length; j++) {
				if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
					String s2 = stones[j][0] + " " + stones[j][1];
					union(parent,s1,s2);
				}
			}
		}
		return stones.length-count;
	}
	public void union(Map<String,String> parent,String s1,String s2) {
		String parent1=find(parent,s1);
		String parent2=find(parent,s2);
		if(parent1.equals(parent2))
			return;
		parent.put(parent1,parent2);
		count--;
	}

	private String find(Map<String, String> parent, String s1) {
		if(!parent.get(s1).equals(s1))
			parent.put(s1, find(parent,parent.get(s1)));
		return parent.get(s1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
