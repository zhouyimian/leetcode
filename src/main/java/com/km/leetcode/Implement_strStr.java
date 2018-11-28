package com.km.leetcode;

public class Implement_strStr {

	public static int main(String[] args) {
		String haystack="aaa",needle="a";
		if(needle.length()==0)
			return 0;
		if(haystack.length()<needle.length())
			return -1;
		else {
			int[] next = new int[needle.length()];
			next = createnext(needle);
			int i=0,j=0;
			while(i<haystack.length()) {
				if(j==-1||haystack.charAt(i)==needle.charAt(j)) {
					i++;
					j++;
				}
				else {
					j=next[j];
				}
				if(j>=needle.length()) {
					System.out.println(i-needle.length());
				}				
			}
			return -1;
		}
	}
	static int[] createnext(String needle) {
		int[] next = new int[needle.length()];
		next[0] = -1;
		int k = -1, j = 0;
		char[] s = needle.toCharArray();
		while (j < needle.length() - 1) {
			if (k == -1 || s[j] == s[k])
				next[++j] = ++k;
			else {
				k = next[k];
			}
		}
		return next;
	}
}
