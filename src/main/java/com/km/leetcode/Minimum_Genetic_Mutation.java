package com.km.leetcode;

import java.util.*;

public class Minimum_Genetic_Mutation {
	public static int minMutation(String start, String end, String[] bank) {
		Queue<String> queue=new ArrayDeque<>();
		Map<String,Integer> map=new HashMap<>();
		for(int i=0;i<bank.length;i++) {
			map.put(bank[i], map.getOrDefault(bank[i], 0)+1);
		}
		if(!map.containsKey(end))
			return -1;
		if(compare(start,end)==1)
			return 1;
		if(start.equals(end))
			return 0;
		int ans=0;
		queue.add(start);
		while(!queue.isEmpty()) {
			ans++;
			int len=queue.size();
			for(int i=0;i<len;i++) {
				String s=queue.poll();
				for(int j=0;j<bank.length;j++) {
					if(map.get(bank[j])==0)
						continue;
					else {
						if(compare(s,bank[j])==1) {
							map.put(bank[j], map.get(bank[j])-1);
							queue.add(bank[j]);
							if(compare(bank[j],end)==1) {
								return ans+1;
							}
						}
					}
				}
			}
		}
		return -1;
	}
	static int compare(String s1,String s2) {
		int count=0;
		for(int i=0;i<s1.length();i++) {
			if(s1.charAt(i)!=s2.charAt(i))
				count++;
		}
		return count;
	}
	public static void main(String[] args) {
		String[] s= {"AACCGGTA","AACCGCTA","AAACGGTA"};
		System.out.println(minMutation("AACCGGTT","AAACGGTA",s));
	}
}
