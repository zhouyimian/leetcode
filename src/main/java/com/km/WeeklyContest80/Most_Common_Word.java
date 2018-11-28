package com.km.WeeklyContest80;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Most_Common_Word {
	public static String mostCommonWord(String paragraph, String[] banned) {
		paragraph=paragraph.toLowerCase();
		paragraph=paragraph.replaceAll("!", " ");
		paragraph=paragraph.replaceAll("\\?", " ");
		paragraph=paragraph.replaceAll("'", " ");
		paragraph=paragraph.replaceAll(",", " ");
		paragraph=paragraph.replaceAll(";", " ");
		paragraph=paragraph.replaceAll("\\.", " ");
		for(int i=0;i<banned.length;i++) {
			paragraph=paragraph.replaceAll(banned[i], " ");
		}
		String[] words=paragraph.split(" +");
		Map<String,Integer> map=new HashMap<>();
		for(int i=0;i<words.length;i++) {
			map.put(words[i], map.getOrDefault(words[i], 0)+1);
		}
		String maxword=null;
		int max=0;
		Set<String> set=map.keySet();
		Iterator it=set.iterator();
		while(it.hasNext()) {
			String s=(String)it.next();
			if(s.equals(""))
				continue;
			if(max<map.get(s)) {
				maxword=s;
				max=map.get(s);
			}
		}
		return maxword;
	}
	public static void main(String[] args) {
		String[] banned= {"bob", "hit"};
		System.out.println(mostCommonWord("Bob. hIt, baLl",banned));
	}
}
