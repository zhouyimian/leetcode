package com.km.leetcode;

public class Excel_Sheet_Column_Title {
	public static String convertToTitle(int n) {
		StringBuilder sb=new StringBuilder();
		while(n!=0){
            n--;
			int num=n%26;
			char c=(char)(num+'A');
			sb.append(c);
			n/=26;
		}
		sb.reverse();
		return new String(sb);
    }
	public static void main(String[] args) {
		System.out.println(convertToTitle(1));
	}
}
