package com.km.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Word_Pattern {
	public static boolean wordPattern(String pattern, String str) {
		
		Map<Character,List<Integer>> map1=new LinkedHashMap<>();
		Map<String,List<Integer>> map2=new LinkedHashMap<>();
		String[] s=str.split(" ");
		if(pattern.length()!=s.length)
			return false;
		int[] count=new int[pattern.length()];
		for(int i=0;i<pattern.length();i++) {
			if(count[i]==1)
				continue;
			else {
				List<Integer> templist=new ArrayList<>();
				templist.add(i);
				char c=pattern.charAt(i);
				for(int j=i+1;j<pattern.length();j++) {
					if(pattern.charAt(j)==c) {
						templist.add(j);
						count[j]=1;
					}
				}
				map1.put(c, templist);
			}
		}
		count=new int[pattern.length()];
		
		for(int i=0;i<s.length;i++) {
			if(count[i]==1)
				continue;
			else {
				List<Integer> templist=new ArrayList<>();
				templist.add(i);
				for(int j=i+1;j<s.length;j++) {
					if(s[j].equals(s[i])) {
						templist.add(j);
						count[j]=1;
					}
				}
				map2.put(s[i], templist);
			}
		}
		
		if(map1.size()!=map2.size())
			return false;
		Collection<List<Integer>> list1=map1.values();
		Collection<List<Integer>> list2=map2.values();
		Iterator it1=list1.iterator();
		Iterator it2=list2.iterator();
		while(it1.hasNext()) {
			List<Integer> l1=(List<Integer>) it1.next();
			List<Integer> l2=(List<Integer>) it2.next();
			if(!l1.containsAll(l2))
				return false;
		}
		
		return true;
	}
	public static void main(String[] args) {
		System.out.println(wordPattern("abba","dog dog dog dog"));
	}
}
