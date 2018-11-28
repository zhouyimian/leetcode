package com.km.leetcode;

public class Decode_Ways {
	static int ans=0;
	public static int numDecodings(String s) {
		if(s.length()==0)
			return 0;
		split(s);
		return ans;
	}
	static void split(String s) {
		if(s.startsWith("0"))
			return;
		if(s.length()==1||s.length()==0) {
			ans++;
			return;
		}
		int num=Integer.parseInt(s.substring(0, 2));
		if((num>0&&num<=26&&s.charAt(1)!='0')) {
			if(s.length()==2) {
				ans+=2;
				return;
			}
			split(s.substring(2));
			split(s.substring(1));
		}
		else {
			if(s.charAt(0)>'2'||s.charAt(1)!='0')
				split(s.substring(1));
			else
				split(s.substring(2));
		}
	}
	public static void main(String[] args) {
		System.out.println(numDecodings("9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253"));
	}
}
