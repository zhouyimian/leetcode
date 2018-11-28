package com.km.leetcode;

import java.util.*;

class ode implements Comparable<ode>{
	String s;
	int fre;
	public ode(String s,int fre) {this.s=s;this.fre=fre;}
	public int compareTo(ode other) {
		if(this.fre>other.fre)
			return -1;
		else if(this.fre<other.fre)
			return 1;
		return s.compareTo(other.s);
	}
}
public class Top_K_Frequent_Words {
	public static List<String> topKFrequent(String[] words, int k) {
		List<String> ans=new ArrayList<>();
		Map<String,Integer> map=new HashMap<>();
		for(int i=0;i<words.length;i++) {
			map.put(words[i], map.getOrDefault(words[i], 0)+1);
		}
		Set<String> set=map.keySet();
		Iterator it=set.iterator();
		Set<ode> s=new TreeSet<>();
		while(it.hasNext()) {
			String key=(String) it.next();
			int fre=map.get(key);
			s.add(new ode(key,fre));
		}
		it=s.iterator();
		int count=0;
		while(it.hasNext()&&count!=k) {
			ans.add(((ode)(it.next())).s);
			count++;
		}
		return ans;
	}
	public static void main(String[] args) {
		String[] words= {"glarko","zlfiwwb","nsfspyox","pwqvwmlgri","qggx","qrkgmliewc","zskaqzwo",
				 "zskaqzwo","ijy","htpvnmozay","jqrlad","ccjel","qrkgmliewc","qkjzgws","fqizrrnmif",
				 "jqrlad","nbuorw","qrkgmliewc","htpvnmozay","nftk","glarko","hdemkfr","axyak",
				 "hdemkfr","nsfspyox","nsfspyox","qrkgmliewc","nftk","nftk","ccjel","qrkgmliewc",
				 "ocgjsu","ijy","glarko","nbuorw","nsfspyox","qkjzgws","qkjzgws","fqizrrnmif","pwqvwmlgri",
				 "nftk","qrkgmliewc","jqrlad","nftk","zskaqzwo","glarko","nsfspyox","zlfiwwb","hwlvqgkdbo",
				 "htpvnmozay","nsfspyox","zskaqzwo","htpvnmozay","zskaqzwo","nbuorw","qkjzgws","zlfiwwb",
				 "pwqvwmlgri","zskaqzwo","qengse","glarko","qkjzgws","pwqvwmlgri","fqizrrnmif","nbuorw",
				 "nftk","ijy","hdemkfr","nftk","qkjzgws","jqrlad","nftk","ccjel","qggx","ijy","qengse",
				 "nftk","htpvnmozay","qengse","eonrg","qengse","fqizrrnmif","hwlvqgkdbo","qengse","qengse",
				 "qggx","qkjzgws","qggx","pwqvwmlgri","htpvnmozay","qrkgmliewc","qengse","fqizrrnmif","qkjzgws",
				 "qengse","nftk","htpvnmozay","qggx","zlfiwwb","bwp","ocgjsu","qrkgmliewc","ccjel","hdemkfr","nsfspyox",
				 "hdemkfr","qggx","zlfiwwb","nsfspyox","ijy","qkjzgws","fqizrrnmif","qkjzgws","qrkgmliewc","glarko","hdemkfr","pwqvwmlgri"};
		topKFrequent(words,14);
	}
}
