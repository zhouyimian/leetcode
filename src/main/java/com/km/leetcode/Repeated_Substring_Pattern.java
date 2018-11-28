package com.km.leetcode;

public class Repeated_Substring_Pattern {
	public static boolean repeatedSubstringPattern(String s) {
		if(s==null)
			return true;
		if(s.length()==1)
			return false;
		else {
			for(int i=1;i<=s.length()/2;i++) {
				if(s.length()%i==0) {
					int len=s.length()/i;
					String temp=s.substring(0, i);
					StringBuilder sb=new StringBuilder();
					for(int j=0;j<len;j++) {
						sb.append(temp);
					}
					if(sb.toString().equals(s))
						return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(repeatedSubstringPattern("bacbacbac"));
	}
}
