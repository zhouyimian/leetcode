package com.km.leetcode;

import java.util.*;

public class Sort_Characters_By_Frequency {
	Map<Character,Integer> map=new TreeMap<>();
	public String frequencySort(String s) {
		for(int i=0;i<s.length();i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
		}
		int len=map.size();
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<len;i++) {
			int max=0;
			Iterator it=map.keySet().iterator();
			char temp = 0;
			while(it.hasNext()) {
				char c=(char) it.next();
				int value=map.get(c);
				if(value>max) {
					max=value;
					temp=c;
				}
			}
			for(int j=0;j<max;j++) {
				sb.append(temp);
			}
			map.remove(temp);
		}
		return new String(sb);
	}
}
