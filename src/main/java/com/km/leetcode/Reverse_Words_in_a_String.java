package com.km.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Reverse_Words_in_a_String {
	public static String reverseWords(String s) {
		StringBuilder sb=new StringBuilder();
		String[] temp=s.split(" ");
		List<String> list=new ArrayList<>();
		for(int i=0;i<temp.length;i++) {
			if(temp[i]==null||temp[i].equals(" ")||temp[i].equals(""))
				continue;
			else
				list.add(temp[i]);
		}
		temp=new String[list.size()];
		list.toArray(temp);
		for(int i=temp.length-1;i>=0;i--) {
			if(temp[i]==null||temp[i].equals(" ")||temp[i].equals(""))
				continue;
			if(i==0)
				sb.append(temp[i]);
			else
				sb.append(temp[i]+" ");
		}
		return new String(sb);
	}

	public static void main(String[] args) {
		System.out.println(reverseWords("the sky is blue"));
	}

}
