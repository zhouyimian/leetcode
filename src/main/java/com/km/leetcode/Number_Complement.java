package com.km.leetcode;

public class Number_Complement {
	public static int findComplement(int num) {
		String s=Integer.toBinaryString(num);
		StringBuffer sb=new StringBuffer(s);
		for(int i=0;i<sb.length();i++) {
			if(sb.charAt(i)=='0')
				sb.setCharAt(i, '1');
			else
				sb.setCharAt(i, '0');
		}
		int ans=0;
		for(int i=0;i<sb.length();i++) {
			ans=ans*2+((int)sb.charAt(i)-'0');
		}
		return ans;
	}
	public static void main(String[] args) {
		findComplement(5);
	}
}
