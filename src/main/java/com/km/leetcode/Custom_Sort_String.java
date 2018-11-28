package com.km.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Custom_Sort_String {
	public String customSortString(String S, String T) {
		StringBuilder sb=new StringBuilder();
		Map<Character,Integer> map=new HashMap<>();
		for(int i=0;i<T.length();i++) {
			map.put(T.charAt(i), map.getOrDefault(T.charAt(i), 0)+1);
		}
		for(int i=0;i<S.length();i++) {
			int count=map.getOrDefault(S.charAt(i), 0);
			if(count!=0) {
				for(int j=0;j<count;j++) {
					sb.append(S.charAt(i));
				}
			}
			map.remove(S.charAt(i));
		}
		Set set=map.keySet();
		Iterator it=set.iterator();
		while(it.hasNext()) {
			char c=(char)it.next();
			int value=map.get(c);
			for(int j=0;j<value;j++) {
				sb.append(c);
			}
		}
		return new String(sb);
	}
}
