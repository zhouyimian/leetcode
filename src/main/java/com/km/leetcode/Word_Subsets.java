package com.km.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Word_Subsets {
	public List<String> wordSubsets(String[] A, String[] B) {
		Map<Character,Integer> need_char=new HashMap<>();
		List<String> ans=new ArrayList<>();
		for(String str:B) {
			Map<Character,Integer> char_num=new HashMap<>();
			for(int i=0;i<str.length();i++) {
				char_num.put(str.charAt(i),char_num.getOrDefault(str.charAt(i), 0)+1);
			}
			for(Character ch:char_num.keySet()) {
				if(need_char.get(ch)==null||need_char.get(ch)<char_num.get(ch)) {
					need_char.put(ch, char_num.get(ch));
				}
			}
		}
		for(int i=0;i<A.length;i++) {
			boolean flag=true;
			Map<Character,Integer> char_num=new HashMap<>();
			for(int j=0;j<A[i].length();j++) {
				char_num.put(A[i].charAt(j),char_num.getOrDefault(A[i].charAt(j), 0)+1);
			}
			for(Character ch:need_char.keySet()) {
				if(char_num.get(ch)==null||char_num.get(ch)<need_char.get(ch)) {
					flag=false;
					break;
				}
			}
			if(flag)
				ans.add(A[i]);
		}
		return ans;
		
	}
}
