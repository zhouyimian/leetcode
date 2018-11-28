package com.km.leetcode;

import java.util.*;

public class MagicDictionary {
	Map<Integer,List<String>> map=new HashMap<>();
	public MagicDictionary() {
		
	}

	/** Build a dictionary through a list of words */
	public void buildDict(String[] dict) {
		for(int i=0;i<dict.length;i++) {
			int len=dict[i].length();
			if(map.containsKey(len)) {
				List<String> list=map.get(len);
				list.add(dict[i]);
				map.put(len, list);
			}
			else {
				List<String> list=new ArrayList<>();
				list.add(dict[i]);
				map.put(len, list);
			}
		}
	}

	/**
	 * Returns if there is any word in the trie that equals to the given word after
	 * modifying exactly one character
	 */
	public boolean search(String word) {
		int len=word.length();
		if(!map.containsKey(len))
			return false;
		else {
			List<String> list=map.get(len);
			for(String s:list) {
				int wrong=0;
				for(int i=0;i<word.length();i++) {
					if(word.charAt(i)!=s.charAt(i)) {
						wrong++;
					}
				}
				if(wrong==1) {
					return true;
				}
				else {
					wrong=0;
				}
			}
		}
		return false;
	}
}
