package com.km.leetcode;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class Number_of_Matching_Subsequences {
	public static int numMatchingSubseq(String S, String[] words) {
		int ans=0;
		Map<Character,LinkedList<String>> map=new LinkedHashMap<>();
		for(int i=0;i<26;i++) {
			map.put((char) ('a'+i), new LinkedList<>());
		}
		for(int i=0;i<words.length;i++) {
			map.get(words[i].charAt(0)).add(words[i]);
		}
		for(int i=0;i<S.length();i++) {
			LinkedList<String> list=map.get(S.charAt(i));
			int size=list.size();
			for(int j=0;j<size;j++) {
				String word=list.removeFirst();
				if(word.length()==1)
					ans++;
				else {
					map.get(word.charAt(1)).addLast(word.substring(1));
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		String s="abcde";
		String[] words= {"a","bb","acd","ace"};
		System.out.println(numMatchingSubseq(s,words));
	}
}
