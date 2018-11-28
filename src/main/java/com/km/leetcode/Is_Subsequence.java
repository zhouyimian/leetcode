package com.km.leetcode;

public class Is_Subsequence {
	public static boolean isSubsequence(String s, String t) {
		if(s.length()==0)
			return true;
		if(s.length()>t.length())
			return false;
		int temp=0;
		int j;
		for(int i=0;i<s.length();i++) {
			for(j=temp;j<t.length();j++) {
				if(s.charAt(i)==t.charAt(j)&&i==s.length()-1) {
					return true;
				}
				if(s.charAt(i)==t.charAt(j)) {
					temp=j+1;
					break;
				}
			}
			if(j==t.length())
				return false;
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(isSubsequence("","ahbgdc"));
	}
}
