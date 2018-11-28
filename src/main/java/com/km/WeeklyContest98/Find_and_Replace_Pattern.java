package com.km.WeeklyContest98;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Find_and_Replace_Pattern {
	public static List<String> findAndReplacePattern(String[] words, String pattern) {
		List<String> ans=new ArrayList<>();
		for(int i=0;i<words.length;i++) {
			if(check(words[i],pattern))
				ans.add(words[i]);
		}
		return ans;
	}

	public static boolean check(String word, String pattern) {
		Map<Character,Character> map=new TreeMap<>();
		for(int i=0;i<word.length();i++) {
			if(map.containsKey(word.charAt(i))) {
				if(pattern.charAt(i)!=map.get(word.charAt(i)))
					return false;
			}
			else {
				map.put(word.charAt(i), pattern.charAt(i));
			}
		}
		map.clear();
		for(int i=0;i<pattern.length();i++) {
			if(map.containsKey(pattern.charAt(i))) {
				if(word.charAt(i)!=map.get(pattern.charAt(i)))
					return false;
			}
			else {
				map.put(pattern.charAt(i), word.charAt(i));
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		String[] words= {"abc","deq","mee","aqq","dkd","ccc"};
		System.out.println(findAndReplacePattern(words,"abb"));
	}

}
