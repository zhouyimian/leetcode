package com.km.leetcode;

import java.util.regex.Pattern;

public class Number_of_Segments_in_a_String {
	public static int countSegments(String s) {
		if(s==null||s.equals(""))
			return 0;
		int ans=0;
		int start=nextchar(s, 0);
		if(start==s.length())
			return 0;
		else 
			ans=1;
		for(int i=start;i<s.length();i++) {
			char c=s.charAt(i);
			if((c>='a'&&c<='z')||(c>='A'&&c<='Z')||c=='\''||c=='-')
				continue;
			else {
				int pos=nextchar(s,i);
				i=nextchar(s,i)-1;
				if(pos==s.length())
					break;
				else
					ans++;
			}
		}
		return ans;
	}
	public static int nextchar(String s,int start) {
		int pos=0;
		while(true) {
			if(start==s.length())
				break;
			char c=s.charAt(start);
			if((c>='a'&&c<='z')||(c>='A'&&c<='Z'))
				break;
			else 
				start++;
		}
		return start;
	}
	public static void main(String[] args) {
		System.out.println(countSegments(", , , ,        a, eaefa"));
	}
}
