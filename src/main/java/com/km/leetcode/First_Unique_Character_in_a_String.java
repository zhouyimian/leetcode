package com.km.leetcode;

import java.util.*;

public class First_Unique_Character_in_a_String {
	public static int firstUniqChar(String s) {
		Map<Character,Integer> map=new LinkedHashMap<>();
		for(int i=0;i<s.length();i++) {
			if(map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), s.length()+1);
			}
			else {
				map.put(s.charAt(i), i);
			}
		}
		Iterator it=map.keySet().iterator();
		while(it.hasNext()) {
			char c=(char) it.next();
			int index=map.get(c);
			if(index!=s.length()+1)
				return index;
		}
		return -1;
	}
	public static void main(String[] args) {
		System.out.println(firstUniqChar("loveleetcode"));
	}
}
