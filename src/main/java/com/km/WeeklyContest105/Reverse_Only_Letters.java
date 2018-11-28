package com.km.WeeklyContest105;

public class Reverse_Only_Letters {
	public String reverseOnlyLetters(String S) {
		if(S==null||S.equals(""))
			return S;
		StringBuilder sb=new StringBuilder(S);
		int start=0;
		int end=sb.length()-1;
		while(start<end) {
			while(start<sb.length()&&check(start,sb))
				start++;
			while(end>=0&&check(end,sb))
				end--;
			if(start<end&&end>=0&&start<sb.length()) {
				char c=sb.charAt(start);
				sb.setCharAt(start, sb.charAt(end));
				sb.setCharAt(end, c);
			}
			start++;
			end--;
		}
		return new String(sb);
	}
	boolean check(int pos,StringBuilder sb) {
		if(sb.charAt(pos)>='A'&&sb.charAt(pos)<='Z')
			return false;
		if(sb.charAt(pos)>='a'&&sb.charAt(pos)<='z')
			return false;
		return true;
	}
}
