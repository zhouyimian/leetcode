package com.km.leetcode;

import java.util.*;

class mycomparator implements Comparator<String> {
	
	public int compare(String s1, String s2) {
		if(s1.length()-s2.length()==0)
			return s1.compareTo(s2);
		return s1.length()-s2.length();
	}
}
public class Replace_Words {
	public static String replaceWords(List<String> dict, String sentence) {
		String[] temp=sentence.split(" ");
		Set<String> set=new TreeSet<>(new mycomparator());
		Iterator it=dict.iterator();
		while(it.hasNext()) {
			set.add((String)it.next());
		}
		for(int i=0;i<temp.length;i++) {
			it=set.iterator();
			while(it.hasNext()) {
				String start=(String) it.next();
				if(start.length()>temp[i].length())
					break;
				else if(temp[i].startsWith(start)) {
					temp[i]=start;
				}
			}
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<temp.length;i++) {
			if(i!=temp.length-1)
				sb.append(temp[i]+" ");
			else
				sb.append(temp[i]);
		}
		return new String(sb);
	}
	public static void main(String[] args) {
		List list=Arrays.asList("cat", "bat", "rat");
		System.out.println(replaceWords(list,"the cattle was rattled by the battery"));
	}
}
