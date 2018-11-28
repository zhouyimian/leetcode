package com.km.leetcode;

import java.util.*;

public class Word_Ladder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Map<String,Integer> map=new HashMap<>();
		for(int i=0;i<wordList.size();i++) {
			if(wordList.get(i).length()==endWord.length())
				map.put(wordList.get(i), map.getOrDefault(wordList.get(i), 1));
			else
				map.put(wordList.get(i), 0);
		}
		if((!map.containsKey(endWord)||beginWord.length()!=endWord.length()))
			return 0;
		if(compare(beginWord,endWord)==1)
			return 2;
		int ans=0;
		Queue<String> queue=new ArrayDeque<String>();
		queue.add(beginWord);
		while(!queue.isEmpty()) {
			ans++;
			int len=queue.size();
			for(int i=0;i<len;i++) {
				String s=queue.poll();
				for(int j=0;j<wordList.size();j++) {
					if(map.get(wordList.get(j))==0)
						continue;
					else {
						if(compare(s,wordList.get(j))==1) {
							map.put(wordList.get(j), 0);
							queue.add(wordList.get(j));
							if(compare(wordList.get(j),endWord)==1)
								return ans+2;
						}
						
					}
				}
			}
		}
		return 0;
	}
	int compare(String s1,String s2) {
		int count=0;
		for(int i=0;i<s1.length();i++) {
			if(s1.charAt(i)!=s2.charAt(i)) {
				count++;
				if(count==2)
					return 2;
			}
		}
		return count;
	}
}
